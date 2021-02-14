package com.example.imdb.service

class IMDBQueryHandlerServiceTest extends org.scalatest.funsuite.AnyFunSuite {

  private val emptyQuery = Query("", 0)
  private val classicQuery = Query("E o vento levou", 15)
  private val invalidQuery = Query("", 15)

  private val service = new IMDBQueryHandlerService

  test("Empty Query must result in ServiceError") {
    val result = service.process(emptyQuery)
    assert(matchLeft[ServiceError.EmptyQueryName](result))
  }

  test( "Invalid Query must result in ServiceError") {
    val result = service.process(invalidQuery)
    assert(matchLeft[ServiceError.EmptyResultList](result))
  }

  test("Valid Query must result in Response") {
    val result = service.process(classicQuery)
    assert(matchLeft[ServiceError.EmptyResultList](result, reverse = true))
  }

  private def matchLeft[A <: ServiceError](in: Either[ServiceError, Response],
                        reverse: Boolean = false): Boolean = {
    case Left(x: A) => !reverse
    case Right(x: Response) => reverse
    case _ => false
  }


}
