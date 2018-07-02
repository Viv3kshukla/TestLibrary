package controllers;

import play.mvc.Controller;
import play.mvc.Result;


@SecureAnnotation
@org.springframework.stereotype.Controller
public class SecondController extends Controller{
	
	public Result index() {
		
		System.out.println("something did happen ");
		
		return ok("hello users , welcome to this world .");
	}
	
	
}
