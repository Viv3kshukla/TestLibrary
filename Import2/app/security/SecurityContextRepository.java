package security;

import org.springframework.security.core.context.SecurityContext;

import play.mvc.Http;

public interface SecurityContextRepository {

    SecurityContext loadContext(Http.Context httpContext);
    void saveContext(SecurityContext securityContext, Http.Context httpContext);
    boolean containsContext(Http.Context httpContext);
	
    
}
