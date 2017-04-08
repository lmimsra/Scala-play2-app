package controllers

import javax.inject._

import dao.BookDAO
import models.Book
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.Form
import play.api.Play._
import scala.concurrent.ExecutionContext.Implicits.global
/**
  * Created by mmr on 2017/02/18.
  */
@Singleton
class DataController @Inject()(bookDao:BookDAO) extends Controller {
  //  def outputData = Action {
  //    val selectQuery = SQL("select * from user")
  //    val result = DB.withConnection { implicit c =>
  //      selectQuery().map(row =>
  //        row[Int]("id") -> (row[String]("userID"), row[String]("name"),row[Int]("age"),row[String]("address"),row[String]("mail"))).toList
  //    }
  //    Ok
  //  }

  //入出力のためのフォームをマッピング
  val bookForm = Form(mapping(
    "id"->longNumber(),
    "title"->text(),
    "author_id"->longNumber()
  )(Book.apply)(Book.unapply)
  )

  //bookのインスタンスを渡して表示
  def indexing = Action.async {
    bookDao.all().map {
      books=>Ok(views.html.database(books))
    }

  }

  //新しくデータを入れる
  def insertData = Action.async { implicit request =>
    val book:Book = bookForm.bindFromRequest.get
    bookDao.insert(book).map(_ => Redirect(routes.DataController.indexing))

  }


//
//  def testOut = Action {implicit c =>
//    val SqlOut: Boolean=true
//    Ok(views.html.database(SqlOut))
//  }
//
  //
}
