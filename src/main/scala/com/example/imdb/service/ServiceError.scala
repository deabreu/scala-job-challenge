package com.example.imdb.service

import com.example.imdb.utils.StringHandler.getNonEmptyString

trait ServiceError extends ServiceLog {
  def message(additionalInfo: String): String
}

object ServiceError {

  case class InvalidRawInputStream(inputStream: String, additionalDetails: String = "") extends ServiceError {
    def message(additionalInfo: String = ""): String =
      s"Raw input $inputStream is invalid${getNonEmptyString(additionalDetails, " due ")}.${getNonEmptyString(additionalInfo, " ")}"
  }

  case class InvalidResponseFromIMDB(responseCode: Int) extends ServiceError {
    override def message(additionalInfo: String = ""): String = s"Response code $responseCode retrieved from connection to IMDB."
  }

  case class EmptyResultList(name: String) extends ServiceError {
    override def message(additionalInfo: String = ""): String = s"Query for $name returned zero results."
  }

  case class EmptyQueryName() extends ServiceError {
    override def message(additionalInfo: String): String = s"Empty Query received"
  }

}
