package controllers

import javax.inject._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.Form
import play.api.Play._
import anorm._
import anorm.SqlParser._

/**
  * Created by mmr on 2017/02/18.
  */
@Singleton
class DataController extends Controller {
  //  def outputData = Action {
  //    val selectQuery = SQL("select * from user")
  //    val result = DB.withConnection { implicit c =>
  //      selectQuery().map(row =>
  //        row[Int]("id") -> (row[String]("userID"), row[String]("name"),row[Int]("age"),row[String]("address"),row[String]("mail"))).toList
  //    }
  //    Ok
  //  }
  def testOut = Action {implicit c =>
    val SqlOut: Boolean=true
    Ok(views.html.database(SqlOut))
  }

  //
}
