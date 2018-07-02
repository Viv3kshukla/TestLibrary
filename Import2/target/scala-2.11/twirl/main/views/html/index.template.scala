
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._

/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>Welcome to Play 2.3</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*6.54*/routes/*6.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*6.101*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*7.59*/routes/*7.65*/.Assets.versioned("images/favicon.png")),format.raw/*7.104*/("""">
        <script data-main=""""),_display_(/*8.29*/routes/*8.35*/.Assets.versioned("javascripts/main.js")),format.raw/*8.75*/(""""
            src=""""),_display_(/*9.19*/routes/*9.25*/.Assets.versioned("lib/requirejs/require.js")),format.raw/*9.70*/("""" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <h1>Welcome to Play 2.3</h1>

            <p>
                The following is a demo showing some CoffeeScript code involving multiple
                files using RequireJS.  This code is also unit tested using mocha.
            </p>

            <p class="source-maps">
                To see Play's source map support, inspect this paragraph with your browsers developer tools.  Locate
                the place where the <code>source-maps</code> style is defined, and browse to the source code.  You
                should find yourself looking at the declaration in <code>main.less</code>.
            </p>

            <p>
                Similarly with CoffeeScript, if you use your browsers script developer tools to open
                <code>Controller.coffee</code>, then you should be able to set a breakpoint in there.
            </p>

            <div id="login">
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input id="password" class="form-control" type="text" value="secret"/>
                </div>
                <button class="btn btn-default" id="connect">Connect</button>
            </div>

            <div id="connecting">Connecting...</div>

            <div id="sum">
                <div class="form-group">
                    <label for="sumValues">Sum the following comma separated values:</label>
                    <input id="sumValues" class="form-control" type="text" value="1,2,3"/>
                </div>
                <dl>
                    <dt>Result</dt>
                    <dd id="sumResult"></dd>
                </dl>

                <button class="btn btn-default" id="submitSum">Sum</button>
                <button class="btn btn-default" id="disconnect">Disconnect</button>
            </div>

        </div>
    </body>
</html>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jul 02 06:40:00 IST 2018
                  SOURCE: /home/vivek/STSProjectsImports/Import2/Import2/app/views/index.scala.html
                  HASH: a7be3a59ddfac1e5de8531260849c10e630f6412
                  MATRIX: 580->0|737->131|751->137|813->178|900->239|914->245|974->284|1031->315|1045->321|1105->361|1151->381|1165->387|1230->432
                  LINES: 22->1|27->6|27->6|27->6|28->7|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9
                  -- GENERATED --
              */
          