package security;


import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.context.SecurityContextHolder;

import controllers.SecureAnnotation;
import controllers.routes;
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
    	
    	System.out.println("\n\n ----- back at SecureAction ----- \n\n");
    	
		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			System.out.println("19.Principal : "+principal);
		}
		catch(Exception e) {
			System.out.println("20.Error : "+e);
		}
    	
    	try {
    		System.out.println("1.ctx : "+ctx);
    		System.out.println("2.securityContextRepository : " + securityContextRepository);
    		securityContextRepository.loadContext(ctx);
    		
    		System.out.println("3.securityContextRepository : " + securityContextRepository);
    		securityContextRepository.saveContext(SecurityContextHolder.getContext(), ctx);
    		System.out.println("4.securityContextRepository : " + securityContextRepository);
    		System.out.println("5.SecurityContextHolder.getContext() : "+ SecurityContextHolder.getContext());
    		
    		System.out.println("the value of ctx is not null or is it ? let's check "+ctx);

    		final F.Promise<Result> promise = delegate.call(ctx);
    		return promise;
    		
    		
    	}
    	catch(AccessDeniedException e) {
    		boolean anonymous =authenticationTrustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication());
    		boolean redirect= (anonymous && !this.configuration.unauthorizedOnAccessDenied());
    		System.out.println("25.AccessDeniedException : "+e);
//    		
//    		final Result promise = redirect(routes.AuthController.showLogin());
    		
    		final Result promise =unauthorized("You are not authorized ");
    		
    		return F.Promise.pure(promise);
    		
    	}
       
    }
}