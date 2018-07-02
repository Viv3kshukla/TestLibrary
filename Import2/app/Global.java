import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pencil.application.PencilApplication;

import play.Application;
import play.GlobalSettings;
public class Global extends GlobalSettings{

     private ApplicationContext ctx;
    
     @Override
     public void onStart(Application arg0) {
  	 ApplicationContext backendCtx = new AnnotationConfigApplicationContext(PencilApplication.class);
 	 ctx = new ClassPathXmlApplicationContext(new String[] {"components.xml","securityComponent.xml"}, backendCtx);
     }
    
     @Override
     public <A> A getControllerInstance(Class<A> type) throws Exception {
           return ctx.getBean(type);
     }
    
}