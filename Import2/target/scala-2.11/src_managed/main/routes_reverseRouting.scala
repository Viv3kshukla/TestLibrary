// @SOURCE:/home/vivek/STSProjectsImports/Import2/Import2/conf/routes
// @HASH:ee399c2ee86ddd3b59e39e268b5348473eee8706
// @DATE:Tue Jul 03 02:11:22 IST 2018

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:24
// @LINE:20
// @LINE:17
// @LINE:15
// @LINE:12
// @LINE:9
// @LINE:7
// @LINE:4
// @LINE:2
package controllers {

// @LINE:24
class ReverseAssets {


// @LINE:24
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
                          

// @LINE:20
// @LINE:17
// @LINE:15
class ReverseAuthController {


// @LINE:20
def logout(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                        

// @LINE:17
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "indexCheck")
}
                        

// @LINE:15
def showLogin(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "formCheck")
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
                  


// @LINE:24
// @LINE:20
// @LINE:17
// @LINE:15
// @LINE:12
// @LINE:9
// @LINE:7
// @LINE:4
// @LINE:2
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:24
class ReverseAssets {


// @LINE:24
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
              

// @LINE:20
// @LINE:17
// @LINE:15
class ReverseAuthController {


// @LINE:20
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AuthController.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:17
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AuthController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "indexCheck"})
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
        


// @LINE:24
// @LINE:20
// @LINE:17
// @LINE:15
// @LINE:12
// @LINE:9
// @LINE:7
// @LINE:4
// @LINE:2
package controllers.ref {


// @LINE:24
class ReverseAssets {


// @LINE:24
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
                          

// @LINE:20
// @LINE:17
// @LINE:15
class ReverseAuthController {


// @LINE:20
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.AuthController]).logout(), HandlerDef(this.getClass.getClassLoader, "", "controllers.AuthController", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:17
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.AuthController]).index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.AuthController", "index", Seq(), "GET", """""", _prefix + """indexCheck""")
)
                      

// @LINE:15
def showLogin(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.AuthController]).showLogin(), HandlerDef(this.getClass.getClassLoader, "", "controllers.AuthController", "showLogin", Seq(), "GET", """""", _prefix + """formCheck""")
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
        
    