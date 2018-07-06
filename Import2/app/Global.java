import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pencil.application.PencilApplication;

import play.Application;
import play.GlobalSettings;
public class Global extends GlobalSettings{

	
	
	
     private ApplicationContext ctx;
//     Map<String,String> hp =new HashMap<String,String>();
     @Override
     public void onStart(Application arg0) {
//     hp.put("vivek","shukla");	
  	 ApplicationContext backendCtx = new AnnotationConfigApplicationContext(PencilApplication.class);
 	 ctx = new ClassPathXmlApplicationContext(new String[] {"components.xml","securityComponent.xml"}, backendCtx);
     }
    
     @Override
     public <A> A getControllerInstance(Class<A> type) throws Exception {
           return ctx.getBean(type);
     }
    
}