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

import com.pencil.application.services.HelloService;

import models.AuthToken;

import javax.inject.Inject;
import play.mvc.Controller;
import play.mvc.Http.Context;
import play.mvc.Result;
import security.HttpSessionSecurityContextRepository;
import views.html.*;

public class AuthController extends Controller	{

	
	@Autowired
	private HelloService service;
	
	
	private final AuthenticationManager authenticationManager;
    private AuthenticationTrustResolver authenticationTrustResolver = new AuthenticationTrustResolverImpl();
	
	public AuthController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	

	
	public Result showLogin() {
		
		System.out.println("this is really something "+ authenticationTrustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication()));
		
		System.out.println("check this out "+SecurityContextHolder.getContext().getAuthentication());
		
		if(authenticationTrustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication())) {
			
			System.out.println("i doubt anything will happen ");
			
			return ok(create.render());
		}
		
		
		return ok("common are you  kidding me . i mean this is very tough . ");
	}
	
	
	public Result index() {
		
		
		
		
		System.out.println("i doubt that captain "+request());
		String username=request().getQueryString("username");
		String password=request().getQueryString("password");		



		System.out.println("the thing is that i also want to check "+Context.current());
		System.out.println("the session is "+session());
		System.out.println("and the password happens to be "+password);
		System.out.println("the name of this  country is "+username);
		
		
        try {
            final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            
            System.out.println("i just wanted to see authentication : "+authentication);
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        catch (AuthenticationException e) {
            HttpSessionSecurityContextRepository.setAuthenticationFailure();

            return badRequest(create.render());
        }
		
		return ok("this is going to be awesome");
	}
	
	
	public Result serviceCheck() {
		
		return ok(service.welcome());
		
	}
	
	
	@PreAuthorize("hasRole('ROLE_USER')")
    public Result logout() {

    	System.out.println("this is inside logout and i just wanted to see what's in it : "+SecurityContextHolder.getContext());
    	
        SecurityContextHolder.getContext().setAuthentication(null);
        SecurityContextHolder.clearContext();
        
        System.out.println("now printing again to see what's inside SecurityContextHolder "+SecurityContextHolder.getContext());
        
        return redirect(routes.AuthController.showLogin());
    }

	
	
}
