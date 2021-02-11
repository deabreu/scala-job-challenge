package com.example.imdb.utils

object StringHandler {

  def getNonEmptyString(in:String, prefix: String = ""): String = if(in.nonEmpty) prefix + in else ""

}
