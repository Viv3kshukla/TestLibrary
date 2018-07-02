package controllers;

import play.mvc.Controller;
import play.mvc.Result;


@SecureAnnotation(unauthorizedOnAccessDenied=true)
@org.springframework.stereotype.Controller
public class SecondController extends Controller{
	
	public Result index() {
		
		
		System.out.println("7 . back inside index : ");
		
		return ok("hello users , welcome to this world .");
	}
	
	
	
}
