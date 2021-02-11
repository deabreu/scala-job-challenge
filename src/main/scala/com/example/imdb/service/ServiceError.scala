package com.example.imdb.service

import com.example.imdb.utils.StringHandler.getNonEmptyString

trait ServiceError {
  def message(additionalInfo: String): String
}

object ServiceError {

  case class InvalidRawInputStream(inputStream: String, additionalDetails: String = "") extends ServiceError {
    def message(additionalInfo: String = ""): String =
      s"Raw input $inputStream is invalid${getNonEmptyString(additionalDetails, " due ")}.${getNonEmptyString(additionalInfo, " ")}"
  }

}
