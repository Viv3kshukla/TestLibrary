package security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.context.SecurityContextImpl;
import play.Play;
import play.mvc.Http;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * A spring SecurityContextHolderStrategy for Playframework 2.x which store the SecurityContext
 * in current play.mvc.Http.Context.
 * Call setSecurityStrategy()to register this SecurityContextHolderStrategy on application start.
 */
public class HttpRequestSecurityContextHolderStrategy
        implements SecurityContextHolderStrategy {
	
    public static void setSecurityStrategy() {
        final String strategyName = HttpRequestSecurityContextHolderStrategy.class.getName();
        if (Play.isProd()) {   
            SecurityContextHolder.setStrategyName(strategyName);
        }
        else {
            try {
                final Field strategy = SecurityContextHolder.class.getDeclaredField("strategy");
                strategy.setAccessible(true);
                strategy.set(null, new HttpRequestSecurityContextHolderStrategy());
            }
            catch (Exception e) {
                throw new Error(e);
            }
        }
    }

    @Override
    public void clearContext() {
        Http.Context.current().args.remove(SECURITY_CONTEXT_PARAM);
    }

    @Override
    public SecurityContext getContext() {
        final boolean containsSecurityContext = (Http.Context.current.get() != null) && Http.Context.current().args.containsKey(SECURITY_CONTEXT_PARAM);
        if (!containsSecurityContext) {
            return SecurityContextHolder.createEmptyContext();
        }

        return (SecurityContext) Http.Context.current().args.get(SECURITY_CONTEXT_PARAM);
    }

    @Override
    public void setContext(SecurityContext context) {
        Http.Context.current().args.put(SECURITY_CONTEXT_PARAM, Objects.requireNonNull(context));
    }

    @Override
    public SecurityContext createEmptyContext() {
        return new SecurityContextImpl();
    }

    private static final String SECURITY_CONTEXT_PARAM = "SECURITY_CONTEXT";

}
