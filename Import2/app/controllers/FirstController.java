package controllers;

import play.mvc.Controller;
import play.mvc.Result;


@org.springframework.stereotype.Controller
public class FirstController extends Controller{
	
	
	public Result welcome() {
		
		return ok("hello users");
	}
	
	
	@VerboseAnnotation(true)
	public Result verboseAnnotationIndex() {
		System.out.println("I guess i would be the last one to be get executed");
		
		return ok("i guess i really does works");
	}
	
	
}
