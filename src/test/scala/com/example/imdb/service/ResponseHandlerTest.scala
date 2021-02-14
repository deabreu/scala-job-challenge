package com.example.imdb.service

import com.example.imdb.utils.URLHandler
import org.jsoup.Jsoup

import scala.jdk.CollectionConverters.CollectionHasAsScala

class ResponseHandlerTest extends org.scalatest.funsuite.AnyFunSuite {

  private val handler = new ResponseHandler
  private val auxiliarHandler = new IMDBQueryHandlerService

  private val validMovieName: MovieName = "E o vento levou"
  private val querysize = 15
  private val validResponse = auxiliarHandler.process(Query(validMovieName, querysize))

  private val invalidMovieName: MovieName = ""
  private val invalidResponse = retrieveFromIMDB


  test("On valid Query return Response"){
    assert( validResponse match {
      case Right(validResponseRight) =>
        handler.process(validResponseRight, validMovieName) match {
          case Right(_: ServiceSuccess) => true
          case _ => false
        }
      case _ => false
    })
  }

  test("On invalid Query return Response"){
    assert( invalidResponse match {
      case Right(invalidResponseRight) =>
        handler.process(invalidResponseRight, invalidMovieName) match {
          case Right(_: ServiceSuccess) => false
          case Left(_: ServiceError.EmptyResultList) => true
          case _ => false
        }
      case _ => false
    })
  }


  private def retrieveFromIMDB : Either[ServiceError, Response] = {
    val baseURL = "https://www.imdb.com/find"
    val parametersMap: Map[String, String] = Map("s" -> "tt","q" -> "","ref_" -> "nv_sr_sm")
    val parameterString = URLHandler.formatQueryParameterString(parametersMap)

    val docTreeJ = Jsoup.connect(baseURL + parameterString).get()
    val resultTextList = docTreeJ.getElementsByClass("result_text")
      val results = resultTextList.asScala.map(el => el.getElementsByTag("a").text()).toSeq
      Right(Response(results, querysize))
  }

}
