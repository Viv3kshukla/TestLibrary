package security;

import controllers.VerboseAnnotation;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

public class VerboseAnnotationAction extends Action<VerboseAnnotation> {
    public F.Promise<Result> call(Http.Context ctx) throws Throwable {
        if (configuration.value()) {
            System.out.println("Calling action for "+ ctx);
            System.out.println("if i ever become true i would be the one to get executed first ");
            
        }
        System.out.println("hey i would win 1st ");
        return delegate.call(ctx);
    }
}