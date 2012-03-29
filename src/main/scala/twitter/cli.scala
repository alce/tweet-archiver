package com.github.alce
package twitter

object updater extends App {
  config.terms foreach { Archiver(_).update }
}