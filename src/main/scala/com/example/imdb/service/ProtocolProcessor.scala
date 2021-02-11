package com.example.imdb.service

import scala.util.Try

class ProtocolProcessor {

  def processRawInput(rawInput: String): Either[ServiceError, Query] = {
    rawInput.split(separator) match {
      case x: Array[String] if x.length >= 2 =>
        Try(x.head.toInt).toOption match {
          case Some(size) =>
            val queryString: String = x.tail.mkString(separator.toString)
            if (queryString.length < size)
              Left(ServiceError.InvalidRawInputStream(rawInput, "Input query smaller than informed size."))
            else
              Right(Query(x.tail.head.substring(0,size)))
          case None => Left(ServiceError.InvalidRawInputStream(rawInput))
        }
      case _ => Left(ServiceError.InvalidRawInputStream(rawInput, s"Could not parse input data for separator ${separator.toString} correctly."))
    }
  }
}
