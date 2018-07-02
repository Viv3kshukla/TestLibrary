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
    		
    		System.out.println("0.  printing out the content of the session "+ ctx.session().get("security-username"));
    		
    		
    		System.out.println("0.  printing out the content of the request "+ ctx.request());
    		
    		System.out.println("1 . ctx : "+ctx);
    		
    		System.out.println("1.5  .  securityContextRepository : " + securityContextRepository);
    		
    		securityContextRepository.loadContext(ctx);
    		
    		System.out.println("4.5  . After loading securityContextRepository : " + securityContextRepository);
    		
    		securityContextRepository.saveContext(SecurityContextHolder.getContext(), ctx);
    		
    		System.out.println("4.8  .  Security Context Holder getContext() "+ SecurityContextHolder.getContext());
    		
    		final F.Promise<Result> promise = delegate.call(ctx);
    		System.out.println("6 . promise : " + promise);
    		return promise;
    	}
    	catch(AccessDeniedException e) {
    		boolean anonymous =authenticationTrustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication());
    		boolean redirect= (anonymous && !this.configuration.unauthorizedOnAccessDenied());
    		
    		if(redirect) {
    			System.out.println("8 . redirect : " + redirect);
    			F.Promise.pure("you are done for the day");
    		}
    		else {
    			System.out.println("9 . anonymous : " + anonymous);
    			F.Promise.pure("well , i am not sure about that");
    		}
    		
    		
    	}
		return null;
       
    }
}