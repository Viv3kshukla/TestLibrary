// @SOURCE:/home/vivek/STSProjectsImports/Import2/Import2/conf/routes
// @HASH:bf95cc2cbde6cea49c4798e25380a210085227ce
// @DATE:Mon Jul 02 13:40:28 IST 2018


import scala.language.reflectiveCalls
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:2
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """""", Routes.prefix + """"""))
        

// @LINE:4
private[this] lazy val controllers_SumController_socket1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sum/"),DynamicPart("password", """[^/]+""",true))))
private[this] lazy val controllers_SumController_socket1_invoker = createInvoker(
controllers.SumController.socket(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SumController", "socket", Seq(classOf[String]),"GET", """""", Routes.prefix + """sum/$password<[^/]+>"""))
        

// @LINE:7
private[this] lazy val controllers_FirstController_verboseAnnotationIndex2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("hello"))))
private[this] lazy val controllers_FirstController_verboseAnnotationIndex2_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.FirstController]).verboseAnnotationIndex(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.FirstController", "verboseAnnotationIndex", Nil,"GET", """""", Routes.prefix + """hello"""))
        

// @LINE:9
private[this] lazy val controllers_FirstController_welcome3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("welcome"))))
private[this] lazy val controllers_FirstController_welcome3_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.FirstController]).welcome(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.FirstController", "welcome", Nil,"GET", """""", Routes.prefix + """welcome"""))
        

// @LINE:12
private[this] lazy val controllers_SecondController_index4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("secureCheck"))))
private[this] lazy val controllers_SecondController_index4_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.SecondController]).index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.SecondController", "index", Nil,"GET", """""", Routes.prefix + """secureCheck"""))
        

// @LINE:16
private[this] lazy val controllers_Assets_versioned5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_versioned5_invoker = createInvoker(
controllers.Assets.versioned(fakeValue[String], fakeValue[Asset]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "versioned", Seq(classOf[String], classOf[Asset]),"GET", """ Use `Assets.versioned` to enable Play 2.3's Asset Fingerprinting""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sum/$password<[^/]+>""","""controllers.SumController.socket(password:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """hello""","""@controllers.FirstController@.verboseAnnotationIndex()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """welcome""","""@controllers.FirstController@.welcome()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """secureCheck""","""@controllers.SecondController@.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.versioned(path:String = "/public", file:Asset)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:2
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index)
   }
}
        

// @LINE:4
case controllers_SumController_socket1_route(params) => {
   call(params.fromPath[String]("password", None)) { (password) =>
        controllers_SumController_socket1_invoker.call(controllers.SumController.socket(password))
   }
}
        

// @LINE:7
case controllers_FirstController_verboseAnnotationIndex2_route(params) => {
   call { 
        controllers_FirstController_verboseAnnotationIndex2_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.FirstController]).verboseAnnotationIndex())
   }
}
        

// @LINE:9
case controllers_FirstController_welcome3_route(params) => {
   call { 
        controllers_FirstController_welcome3_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.FirstController]).welcome())
   }
}
        

// @LINE:12
case controllers_SecondController_index4_route(params) => {
   call { 
        controllers_SecondController_index4_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.SecondController]).index())
   }
}
        

// @LINE:16
case controllers_Assets_versioned5_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned5_invoker.call(controllers.Assets.versioned(path, file))
   }
}
        
}

}
     