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
        
        System.out.println("2 . securityContext : "+ securityContext);
        
        UserDetails user;
        if (isHttpContextSessionContainsSecurityUsername(context)) {
            final String username = getSecuritySessionUsername(context);

            try {
                final boolean anonymous = SECURITY_ANONYMOUS_USERNAME.equals(username);
                user = anonymous ? null: userService.loadUserByUsername(username);
            }
            catch (UsernameNotFoundException e) {user = null;}
        }
        else {user = null;}

        final Authentication authentication = (user == null)
                ? createAnonymousAuthenticationToken()
                : new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
        
        securityContext.setAuthentication(authentication);
        context.request().setUsername(authentication.getName());
        context.args.put(SECURITY_EXPRESSION_OPERATIONS_KEY, securityExpressionOperationsSupplier.get());

        return securityContext;
    }

    static AnonymousAuthenticationToken createAnonymousAuthenticationToken() {
        return new AnonymousAuthenticationToken(SECURITY_ANONYMOUS_KEY, SECURITY_ANONYMOUS_USERNAME, createAuthorityList(Roles.ROLE_ANONYMOUS));
    }

    @Override
    public void saveContext(SecurityContext securityContext, Http.Context context) {
        final Authentication authentication = securityContext.getAuthentication();
        
        System.out.println("3 . authentication : "+ authentication);
        
        if (authentication == null || !authentication.isAuthenticated()) {
        	
        	System.out.println("4 . context.session() : " + context.session());
            context.session().remove(SECURITY_USERNAME_PARAM);
            
        }
        else {
            final String username = authentication.getName();
            System.out.println("5 . context.session() : " + context.session());
            context.session().put(SECURITY_USERNAME_PARAM, username);
        }
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
