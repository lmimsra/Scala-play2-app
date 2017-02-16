package controllers

import javax.inject.Singleton
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.Form
/**
  * Created by mmr on 2017/02/10.
  */
case class User(name: String, age: Int, sex: String, other: Other)
case class Other(hobby: String, place: String, birthday: String)

@Singleton
class UserController extends Controller {
 // val form = Form( "name" -> text )
  val form = Form[User](mapping("name" -> text, "age" -> number, "sex" -> text,
    "other" ->mapping("hobby" -> text,"place" -> text, "birthday" -> text)(Other.apply)(Other.unapply))(User.apply)(User.unapply))
  def outputPage = Action{implicit request =>
    val inUser =form.bindFromRequest.get
    Ok(views.html.output(inUser.name,inUser.age,inUser.sex,inUser.other.place))
  }

}
