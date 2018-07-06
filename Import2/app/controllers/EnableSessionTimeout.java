package controllers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import play.mvc.With;
import security.SessionTimeoutAction;

@With(SessionTimeoutAction.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableSessionTimeout {

	boolean redirectToConfiguredPageOnTimeout() default true;
	
	boolean updateOnly() default true;
	
	
}
