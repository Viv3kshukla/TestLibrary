// @SOURCE:/home/vivek/STSProjectsImports/Import2/Import2/conf/routes
// @HASH:80aeb6b78ad71fa3639d2f60adf63f94c5384540
// @DATE:Thu Jul 05 13:34:38 IST 2018

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:40
// @LINE:34
// @LINE:31
// @LINE:28
// @LINE:25
// @LINE:22
// @LINE:18
// @LINE:15
// @LINE:12
// @LINE:9
// @LINE:7
// @LINE:4
// @LINE:2
package controllers {

// @LINE:40
class ReverseAssets {


// @LINE:40
def versioned(file:Asset): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[Asset]].unbind("file", file))
}
                        

}
                          

// @LINE:4
class ReverseSumController {


// @LINE:4
def socket(password:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "sum/" + implicitly[PathBindable[String]].unbind("password", dynamicString(password)))
}
                        

}
                          

// @LINE:12
class ReverseSecondController {


// @LINE:12
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "secureCheck")
}
                        

}
                          

// @LINE:2
class ReverseApplication {


// @LINE:2
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

}
                          

// @LINE:34
// @LINE:31
// @LINE:28
// @LINE:25
// @LINE:22
// @LINE:18
// @LINE:15
class ReverseAuthController {


// @LINE:34
def publicAccessCheck(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "publicAccessCheck")
}
                        

// @LINE:31
def anywayCheck(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "anyway")
}
                        

// @LINE:28
def serviceCheck(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "greet")
}
                        

// @LINE:25
def logout(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                        

// @LINE:18
def welcomePage(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "welcomePage")
}
                        

// @LINE:15
def showLogin(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "formCheck")
}
                        

// @LINE:22
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "indexCheck")
}
                        

}
                          

// @LINE:9
// @LINE:7
class ReverseFirstController {


// @LINE:9
def welcome(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "welcome")
}
                        

// @LINE:7
def verboseAnnotationIndex(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "hello")
}
                        

}
                          
}
                  


// @LINE:40
// @LINE:34
// @LINE:31
// @LINE:28
// @LINE:25
// @LINE:22
// @LINE:18
// @LINE:15
// @LINE:12
// @LINE:9
// @LINE:7
// @LINE:4
// @LINE:2
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:40
class ReverseAssets {


// @LINE:40
def versioned : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.versioned",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:4
class ReverseSumController {


// @LINE:4
def socket : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SumController.socket",
   """
      function(password) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sum/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("password", encodeURIComponent(password))})
      }
   """
)
                        

}
              

// @LINE:12
class ReverseSecondController {


// @LINE:12
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SecondController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "secureCheck"})
      }
   """
)
                        

}
              

// @LINE:2
class ReverseApplication {


// @LINE:2
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              

// @LINE:34
// @LINE:31
// @LINE:28
// @LINE:25
// @LINE:22
// @LINE:18
// @LINE:15
class ReverseAuthController {


// @LINE:34
def publicAccessCheck : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AuthController.publicAccessCheck",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "publicAccessCheck"})
      }
   """
)
                        

// @LINE:31
def anywayCheck : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AuthController.anywayCheck",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "anyway"})
      }
   """
)
                        

// @LINE:28
def serviceCheck : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AuthController.serviceCheck",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "greet"})
      }
   """
)
                        

// @LINE:25
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AuthController.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:18
def welcomePage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AuthController.welcomePage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "welcomePage"})
      }
   """
)
                        

// @LINE:15
def showLogin : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AuthController.showLogin",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "formCheck"})
      }
   """
)
                        

// @LINE:22
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AuthController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "indexCheck"})
      }
   """
)
                        

}
              

// @LINE:9
// @LINE:7
class ReverseFirstController {


// @LINE:9
def welcome : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.FirstController.welcome",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "welcome"})
      }
   """
)
                        

// @LINE:7
def verboseAnnotationIndex : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.FirstController.verboseAnnotationIndex",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hello"})
      }
   """
)
                        

}
              
}
        


// @LINE:40
// @LINE:34
// @LINE:31
// @LINE:28
// @LINE:25
// @LINE:22
// @LINE:18
// @LINE:15
// @LINE:12
// @LINE:9
// @LINE:7
// @LINE:4
// @LINE:2
package controllers.ref {


// @LINE:40
class ReverseAssets {


// @LINE:40
def versioned(path:String, file:Asset): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.versioned(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "versioned", Seq(classOf[String], classOf[Asset]), "GET", """ Use `Assets.versioned` to enable Play 2.3's Asset Fingerprinting""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:4
class ReverseSumController {


// @LINE:4
def socket(password:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SumController.socket(password), HandlerDef(this.getClass.getClassLoader, "", "controllers.SumController", "socket", Seq(classOf[String]), "GET", """""", _prefix + """sum/$password<[^/]+>""")
)
                      

}
                          

// @LINE:12
class ReverseSecondController {


// @LINE:12
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.SecondController]).index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.SecondController", "index", Seq(), "GET", """""", _prefix + """secureCheck""")
)
                      

}
                          

// @LINE:2
class ReverseApplication {


// @LINE:2
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """""", _prefix + """""")
)
                      

}
                          

// @LINE:34
// @LINE:31
// @LINE:28
// @LINE:25
// @LINE:22
// @LINE:18
// @LINE:15
class ReverseAuthController {


// @LINE:34
def publicAccessCheck(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.AuthController]).publicAccessCheck(), HandlerDef(this.getClass.getClassLoader, "", "controllers.AuthController", "publicAccessCheck", Seq(), "GET", """""", _prefix + """publicAccessCheck""")
)
                      

// @LINE:31
def anywayCheck(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.AuthController]).anywayCheck(), HandlerDef(this.getClass.getClassLoader, "", "controllers.AuthController", "anywayCheck", Seq(), "GET", """""", _prefix + """anyway""")
)
                      

// @LINE:28
def serviceCheck(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.AuthController]).serviceCheck(), HandlerDef(this.getClass.getClassLoader, "", "controllers.AuthController", "serviceCheck", Seq(), "GET", """""", _prefix + """greet""")
)
                      

// @LINE:25
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.AuthController]).logout(), HandlerDef(this.getClass.getClassLoader, "", "controllers.AuthController", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:18
def welcomePage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.AuthController]).welcomePage(), HandlerDef(this.getClass.getClassLoader, "", "controllers.AuthController", "welcomePage", Seq(), "GET", """""", _prefix + """welcomePage""")
)
                      

// @LINE:15
def showLogin(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.AuthController]).showLogin(), HandlerDef(this.getClass.getClassLoader, "", "controllers.AuthController", "showLogin", Seq(), "GET", """""", _prefix + """formCheck""")
)
                      

// @LINE:22
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.AuthController]).index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.AuthController", "index", Seq(), "GET", """""", _prefix + """indexCheck""")
)
                      

}
                          

// @LINE:9
// @LINE:7
class ReverseFirstController {


// @LINE:9
def welcome(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.FirstController]).welcome(), HandlerDef(this.getClass.getClassLoader, "", "controllers.FirstController", "welcome", Seq(), "GET", """""", _prefix + """welcome""")
)
                      

// @LINE:7
def verboseAnnotationIndex(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.FirstController]).verboseAnnotationIndex(), HandlerDef(this.getClass.getClassLoader, "", "controllers.FirstController", "verboseAnnotationIndex", Seq(), "GET", """""", _prefix + """hello""")
)
                      

}
                          
}
        
    