package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.Form
import play.api.i18n.Messages.Implicits._
import play.api.i18n.{I18nSupport, MessagesApi}
/**
  * Created by mmr on 2017/02/10.
  */
case class User(name: String, age: Int, sex: String, other: Other)
case class Other(hobby: String, place: String, birthday: String)


@Singleton
class UserController @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport{
 // val form = Form( "name" -> text )
  val Userform = Form[User](mapping("name" -> nonEmptyText, "age" -> number(strict = true), "sex" -> nonEmptyText,
    "other" ->mapping("hobby" -> nonEmptyText,"place" -> nonEmptyText, "birthday" -> nonEmptyText)(Other.apply)(Other.unapply))(User.apply)(User.unapply))

  def initialise = Action{implicit request =>
    Ok(views.html.input(Userform))
  }

  def outputPage = Action{implicit request =>
    val inUser =Userform.bindFromRequest.get
    Ok(views.html.output(inUser.name,inUser.age,inUser.sex,inUser.other.place))
  }



}
