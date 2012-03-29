package com.github.alce 
package twitter

import com.mongodb.casbah.Imports._
import com.mongodb.util.JSON
import dispatch._

class Archiver(private val term: String) {
  
  private val tweets = MongoConnection()(config.databaseName)(config.collectionName)

  tweets createIndex(DBObject("tags" -> 1, "id" -> -1))
  tweets ensureIndex(DBObject("id" -> 1), "", true)

  def update {
    println("Starting twitter search for " + term)
    save_tweets_for(term)
  }

  private def save_tweets_for(term: String) {
    val http = new Http
    val response = http(twitter.Search(term))
    http.shutdown()
    response foreach { tweet =>
      tweets save {
        JSON.parse(tweet.toString).asInstanceOf[DBObject] += "tags" -> List(term)
      } 
    }
  }
}

object Archiver {
  def apply(term: String) = new Archiver(term) 
}