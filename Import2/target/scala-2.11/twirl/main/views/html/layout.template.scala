
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
object layout extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title:String)(body:Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.27*/("""


"""),format.raw/*4.1*/("""<html>
	<head><title>"""),_display_(/*5.16*/title),format.raw/*5.21*/("""</title></head>
	<body>
	
	"""),_display_(/*8.3*/body),format.raw/*8.7*/("""
	
	"""),format.raw/*10.2*/("""</body>


</html>"""))}
  }

  def render(title:String,body:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(body)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (body) => apply(title)(body)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Jul 03 00:36:48 IST 2018
                  SOURCE: /home/vivek/STSProjectsImports/Import2/Import2/app/views/layout.scala.html
                  HASH: 4b1356c33fbaffc45e681f7128b36cbec1223ed5
                  MATRIX: 511->1|624->26|653->29|701->51|726->56|779->84|802->88|833->92
                  LINES: 19->1|22->1|25->4|26->5|26->5|29->8|29->8|31->10
                  -- GENERATED --
              */
          