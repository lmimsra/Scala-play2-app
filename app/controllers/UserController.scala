package controllers

import javax.inject.Singleton
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.Form
/**
  * Created by mmr on 2017/02/10.
  */
case class User(name: String, email: String, age: Int)

@Singleton
class UserController extends Controller {
  val form = Form( "name" -> text )
  def outputPage = Action{implicit request =>
    val Username =form.bindFromRequest.get
    Ok(views.html.output(Username))
  }

}
