package com.example.imdb.service

import scala.annotation.tailrec

class ResponseHandler {

  private val separator = '\n'

  def process(imdbQuery: Response, originalQuery: MovieName): Either[ServiceError, ServiceSuccess] = {
    val clipedResult = getFirstResults(imdbQuery.querySize, Seq.empty, imdbQuery.names)

    val results = if (clipedResult.nonEmpty) clipedResult.mkString(separator.toString) else ""

    if (results.nonEmpty)
      Right(ServiceSuccess.FormattedResponse(s"${imdbQuery.querySize}:$results"))
    else
      Left(ServiceError.EmptyResultList(originalQuery))
  }

  @tailrec
  private def getFirstResults(remainingResults: Int, result: Seq[String], remaining: Seq[String]): Seq[String] =
    if (remainingResults > 0)
      getFirstResults(remainingResults - 1, result ++ Seq(remaining.head), remaining.tail)
    else
      result

}
