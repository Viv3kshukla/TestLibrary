package security;

import java.time.Clock;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.apache.commons.lang3.math.NumberUtils;

import controllers.EnableSessionTimeout;
import play.api.mvc.Call;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

public class SessionTimeoutAction extends Action<EnableSessionTimeout>{


    private final Clock clock;
    private final int securitySessionDurationMinutes;
    private final Call redirectRoute;
	
    private static final String SESSION_TIMEOUT_TIMESTAMP_PARAM = "session-timeout-timestamp";
    private static final String SESSION_TIMEOUT_FLASH_KEY = "session-timeout-expired";
    
    
	public SessionTimeoutAction(final Clock clock,final int securitySessionDurationMinutes,final Call redirectRoute) {
		this.clock=clock;
		this.securitySessionDurationMinutes=securitySessionDurationMinutes;
		this.redirectRoute=redirectRoute;
	}
	
	public F.Promise<Result> call(Http.Context ctx) throws Throwable{
		
		final F.Promise<Result> resultPromise;
		
		if(this.configuration.updateOnly() && checkSessionTimeout(ctx)) {
			forceSessionTimeout();
			
			Controller.flash(SESSION_TIMEOUT_FLASH_KEY, "true");
			
			final Result result = this.configuration.redirectToConfiguredPageOnTimeout() ? Results.redirect(this.redirectRoute):redirect(ctx.request().uri());
			
			resultPromise = F.Promise.pure(result);
			
		}
		else {
			resultPromise = delegate.call(ctx);
		}
		
		updateSessionDate(ctx);
		
		return resultPromise;
	}
	
	private boolean checkSessionTimeout(final Http.Context ctx) {
		final String lastRequestDate = ctx.session().get(SESSION_TIMEOUT_TIMESTAMP_PARAM);
		final Instant lastRequestInstant = Instant.ofEpochMilli(NumberUtils.toLong(lastRequestDate));
		final Instant instant = clock.instant();
		
		final boolean expired = lastRequestInstant.plus(securitySessionDurationMinutes,ChronoUnit.MINUTES).isBefore(instant);
		
		return expired;
		
	}
	
	private void updateSessionDate(final Http.Context ctx) {
		final Instant instant=clock.instant();
		ctx.session().put(SESSION_TIMEOUT_TIMESTAMP_PARAM,Long.toString(instant.toEpochMilli()));
	}
	
	public static void forceSessionTimeout() {
		Http.Context.current().session().clear();
	}
	
    public static boolean isSessionTimeout() {
        return Controller.flash(SESSION_TIMEOUT_FLASH_KEY) != null;
    }

	
}
