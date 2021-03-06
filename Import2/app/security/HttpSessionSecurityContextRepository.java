package security;

import java.util.function.Supplier;

import org.springframework.security.access.expression.SecurityExpressionOperations;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import static org.springframework.security.core.authority.AuthorityUtils.createAuthorityList;

import models.Roles;
import play.mvc.Controller;
import play.mvc.Http;

import security.SecurityContextRepository;;


//A SecurityContextRepository implementation which stores the security context in the Http.Session
//between requests.
//Must be called first in http request filter or action composition.
//Inspired by  org.springframework.security.web.context.HttpSessionSecurityContextRepository.
	
	

public class HttpSessionSecurityContextRepository implements SecurityContextRepository{

    private final UserDetailsService userService;
    private final Supplier<SecurityExpressionOperations> securityExpressionOperationsSupplier;
    
    
    private static final String SECURITY_EXPRESSION_OPERATIONS_KEY = "SECURITY_EXPRESSION_OPERATIONS";
    public static final String SECURITY_USERNAME_PARAM = "security-username";
    public static final String SECURITY_ANONYMOUS_KEY = "security-anonymous-key";
    public static final String SECURITY_AUTHENTICATION_FAILURE_FLASH_KEY = "security-auth-failure";
    public static final String SECURITY_ANONYMOUS_USERNAME = "ANONYMOUS";

    
    public HttpSessionSecurityContextRepository(
            final UserDetailsService userService,
            final Supplier<SecurityExpressionOperations> securityExpressionOperationsSupplier
    ) {
        this.userService = userService;
        this.securityExpressionOperationsSupplier = securityExpressionOperationsSupplier;
    }
    
    @Override
    public SecurityContext loadContext(Http.Context context) {
    	
        final SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        SecurityContextHolder.setContext(securityContext);
        
        System.out.println("6.securityContext : " + securityContext);
        System.out.println("7.context : " + context);        
        System.out.println("30.contextKey : "+context.session().get(SECURITY_USERNAME_PARAM));
        UserDetails user;
        if (isHttpContextSessionContainsSecurityUsername(context)) {
            final String username = getSecuritySessionUsername(context);
            System.out.println("8.username : " + username);
            try {
                final boolean anonymous = SECURITY_ANONYMOUS_USERNAME.equals(username);
                user = anonymous ? null: userService.loadUserByUsername(username);
                System.out.println("11.anonymous : "+anonymous);
                System.out.println("10.user : "+user);
            }
            catch (UsernameNotFoundException e) {user = null;}
        }
        else {user = null;}
        final Authentication authentication = (user == null)
                ? createAnonymousAuthenticationToken()
                : new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
        
        System.out.println("38.authentication : "+authentication);
        securityContext.setAuthentication(authentication);
        context.request().setUsername(authentication.getName());
        System.out.println("39.authentication.getName() : "+authentication.getName()); 
        context.args.put(SECURITY_EXPRESSION_OPERATIONS_KEY, securityExpressionOperationsSupplier.get());
        System.out.println("40.context : "+context);
        return securityContext;
    }

    @Override
    public void saveContext(SecurityContext securityContext, Http.Context context) {
        final Authentication authentication = securityContext.getAuthentication();
        
        System.out.println("21.authentication : "+ authentication);
        
        if (authentication == null || !authentication.isAuthenticated()) {
        	
        	System.out.println("22.context.session() : " + context.session());
            context.session().remove(SECURITY_USERNAME_PARAM);
            
        }
        else {
            final String username = authentication.getName();
            System.out.println("23.context.session() : " + context.session());
            context.session().put(SECURITY_USERNAME_PARAM, username);
        }
    }
    
    static AnonymousAuthenticationToken createAnonymousAuthenticationToken() {
        return new AnonymousAuthenticationToken(SECURITY_ANONYMOUS_KEY, SECURITY_ANONYMOUS_USERNAME, createAuthorityList(Roles.ROLE_ANONYMOUS));
    }

    public static String getSecuritySessionUsername(Http.Context context) {
        return context.session().get(SECURITY_USERNAME_PARAM);
    }
    
    @Override
    public boolean containsContext(Http.Context context) {
        return isHttpContextSessionContainsSecurityUsername(context);
    }
    
    public static void setAuthenticationFailure() {
        Controller.flash(SECURITY_AUTHENTICATION_FAILURE_FLASH_KEY, "true");
    }

    public static SecurityExpressionOperations getSecurityExpressionOperations(Http.Context httpContext) {
        return (SecurityExpressionOperations) httpContext.args.get(SECURITY_EXPRESSION_OPERATIONS_KEY);
    }
    
    private static boolean isHttpContextSessionContainsSecurityUsername(Http.Context context) {
        return context.session().containsKey(SECURITY_USERNAME_PARAM);
    }

    
	
	
	
}
