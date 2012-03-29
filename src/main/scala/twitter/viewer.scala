package com.github.alce
package twitter

import org.scalatra._
import scalate.ScalateSupport
import com.mongodb.casbah.Imports._

class Viewer extends ScalatraServlet with ScalateSupport {

  private val tweetsDB = MongoConnection()(config.databaseName)(config.collectionName)

  get("/") {

    val selector = DBObject()
    val term = params.getOrElse("tag", false)
    // TODO: Investigate better way to deal with Option
    if (term != false) selector += "tags" -> term.asInstanceOf[String]

    contentType = "text/html"
    scaml("tweets.scaml", "tweets" -> tweetsDB.find(selector), "terms" -> config.terms)
  }
}