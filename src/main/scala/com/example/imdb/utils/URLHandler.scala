package com.example.imdb.utils

object URLHandler {

  def formatQueryString(inputString: String): String = inputString.trim.map(c => if (c == ' ') '+' ).mkString

  def formatQueryParameterString(parameters: Map[String, String]):String =
    if (parameters.nonEmpty)
      parameters.map(el => s"${el._1}=${el._2}").mkString("&").prependedAll("?")
    else ""

}
