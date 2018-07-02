package security;


import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.context.SecurityContextHolder;

import controllers.SecureAnnotation;
import play.api.mvc.Call;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import security.HttpSessionSecurityContextRepository;

public class SecureAction extends Action<SecureAnnotation> {

	private final HttpSessionSecurityContextRepository securityContextRepository;
//    private final Call redirectRoute;

    private AuthenticationTrustResolver authenticationTrustResolver = new AuthenticationTrustResolverImpl();

	public SecureAction(final HttpSessionSecurityContextRepository securityContextRepository) {
		this.securityContextRepository = securityContextRepository;
//        this.redirectRoute = redirectRoute;
	}
	
    public F.Promise<Result> call(Http.Context ctx) throws Throwable {
    	try {
    		
    		securityContextRepository.loadContext(ctx);
    		securityContextRepository.saveContext(SecurityContextHolder.getContext(), ctx);
    		
    		final F.Promise<Result> promise = delegate.call(ctx);
    		return promise;
    	}
    	catch(AccessDeniedException e) {
    		boolean anonymous =authenticationTrustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication());
    		boolean redirect= (anonymous && !this.configuration.unauthorizedOnAccessDenied());
    		
    		if(redirect) {
    			System.out.println("this is nothing ");
    			F.Promise.pure("you are done for the day");
    		}
    		else {
    			System.out.println("are you sure about that");
    			F.Promise.pure("well , i am not sure about that");
    		}
    		
    		
    	}
		return null;
       
    }
}