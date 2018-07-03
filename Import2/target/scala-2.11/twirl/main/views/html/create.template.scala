
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
object create extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*3.2*/layout("Enter credentials")/*3.29*/{_display_(Seq[Any](format.raw/*3.30*/("""

"""),format.raw/*5.1*/("""<form action="""),_display_(/*5.15*/routes/*5.21*/.AuthController.index()),format.raw/*5.44*/(""">
  Username : <br>
  <input type="text" name="username" value="username">
  <br>
  Password :<br>
  <input type="password" name="password" value="password">
  <br><br>
  <input type="submit" value="Submit">
</form> 

""")))}))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Jul 03 16:29:07 IST 2018
                  SOURCE: /home/vivek/STSProjectsImports/Import2/Import2/app/views/create.scala.html
                  HASH: 2fa370f16dc59bdfac25475da13a04f66e7e1a91
                  MATRIX: 581->3|616->30|654->31|682->33|722->47|736->53|779->76
                  LINES: 22->3|22->3|22->3|24->5|24->5|24->5|24->5
                  -- GENERATED --
              */
          