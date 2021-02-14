package com.example.imdb.service

class WorkFlowTest extends org.scalatest.funsuite.AnyFunSuite {

  private val validMovieNames = Seq("15:E o vento levou",  "15:   E o vento levou    ", "15:   E o vento levou ")

  private val invalidMovieNames = Seq(":E o vento levou", "E o vento levou", "")

  test("Valid movie names should return Rigth Service Success") {
    for (name <- validMovieNames) assert( WorkFlow.runFor(name) match {
      case Right(_:ServiceSuccess.FormattedResponse) => true
      case _ => false
    })
  }

  test("Invalid movie names should return Left Service Error") {
    for (name <- invalidMovieNames) assert( WorkFlow.runFor(name) match {
      case Left(_:ServiceError) => true
      case _ => false
    })
  }

}
