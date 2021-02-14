package com.example.imdb.service

trait ServiceSuccess extends ServiceLog {

  def getValue: String

}

object ServiceSuccess {

  case class FormattedResponse(response: String) extends ServiceSuccess{
    override def getValue: String = response
  }
}
