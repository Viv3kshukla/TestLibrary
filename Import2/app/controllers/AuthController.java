package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pencil.application.services.HelloService;

import models.AuthToken;

import javax.inject.Inject;
import play.mvc.Controller;
import play.mvc.Http.Context;
import play.mvc.Result;
import security.HttpSessionSecurityContextRepository;
import views.html.*;

@SecureAnnotation(unauthorizedOnAccessDenied=true)
public class AuthController extends Controller	{

	
	@Autowired
	private HelloService service;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	private final AuthenticationManager authenticationManager;
    private AuthenticationTrustResolver authenticationTrustResolver = new AuthenticationTrustResolverImpl();
	
	public AuthController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	public Result showLogin() {
		
		System.out.println("14. isAnonymous : "+ authenticationTrustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication()));
		System.out.println("15. SecurityContextHolder.getContext() : "+SecurityContextHolder.getContext().getAuthentication());
		
		if(authenticationTrustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication())) {	
			return ok(create.render());
		}
		return ok("Not Anonymous");
	}
	
	public Result index() {

		String username=request().getQueryString("username");
		String password=request().getQueryString("password");		
		System.out.println("12.session : "+session());
		
        try {
            final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            System.out.println("13.authentication : "+authentication);
            session().put(HttpSessionSecurityContextRepository.SECURITY_USERNAME_PARAM,username);
            SecurityContextHolder.getContext().setAuthentication(authentication);
    		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    		System.out.println("14.principal : "+ principal);
            return redirect(routes.AuthController.welcomePage());
        }
        catch (AuthenticationException e) {
            HttpSessionSecurityContextRepository.setAuthenticationFailure();
            return badRequest(create.render());
        }
		
	}
	
	
	public Result welcomePage() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("15.principal : "+ principal);
		
		if (principal instanceof UserDetails) {
			String username = ((UserDetails)principal).getUsername();
			System.out.println("16.username : "+username);
		}  
		else {
			String username = principal.toString();
			System.out.println("17.username : "+username);
			
			return ok("get authenticated first "+principal);
			
		}
		return ok("Welcome "+principal);
	}
	
	public Result serviceCheck() {
		
		return ok(service.welcome());
		
	}
	
	public Result anywayCheck() {
		return ok(service.anyway());
	}
	
	public Result publicAccessCheck() {
		return ok(service.publicAccess());
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
    public Result logout() {

    	System.out.println("18.SecurityContextHolder.getAuthentication : "+SecurityContextHolder.getContext());

        SecurityContextHolder.getContext().setAuthentication(null);
        SecurityContextHolder.clearContext();
        session().clear();
   
        return redirect(routes.AuthController.showLogin());
    }

	
	
}
