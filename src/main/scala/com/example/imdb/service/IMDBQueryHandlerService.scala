package com.example.imdb.service

import com.example.imdb.utils.URLHandler
import org.jsoup.Jsoup

import scala.jdk.CollectionConverters.CollectionHasAsScala


class IMDBQueryHandlerService {

  def process(query: Query): Either[ServiceError, Response] = {
    //https://www.imdb.com/find?s=tt&q=cidade&ref_=nv_sr_sm
    val baseURL = "https://www.imdb.com/find"
    val clippedTitle = URLHandler.formatQueryString(query.movieNames)

    if (clippedTitle.nonEmpty) {
      val parametersMap: Map[String, String] = Map("s" -> "tt","q" -> clippedTitle,"ref_" -> "nv_sr_sm")
      val parameterString = URLHandler.formatQueryParameterString(parametersMap)
      val docTreeJ = Jsoup.connect(baseURL + parameterString).get()
      val resultTextList = docTreeJ.getElementsByClass("result_text")
      if (resultTextList.size() > 0) {
        val results = resultTextList.asScala.map(el => el.getElementsByTag("a").text()).toSeq
        Right(Response(results, query.querySize))
      } else Left (ServiceError.EmptyResultList(query.movieNames))
    } else Left(ServiceError.EmptyQueryName())

  }

}
