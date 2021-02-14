package com.example.imdb.service

class InputHandlerTest extends org.scalatest.funsuite.AnyFunSuite {
  private val testProcessor = new InputHandler

  private val invalidInputCase1 = "E o vento levou"
  private val invalidInputCase2 = "*:E o vento levou"
  private val invalidInputCase3 = ":E o vento levou"

  private val validInput = "15:E o vento levou"

  test("InputHandler must return a ServiceError Invalid Input Stream") {
    val result1 = testProcessor.processRawInput(invalidInputCase1)
    val result2 = testProcessor.processRawInput(invalidInputCase2)
    val result3 = testProcessor.processRawInput(invalidInputCase3)
    assert(matchLeftInvalidRawInput(result1))
    assert(matchLeftInvalidRawInput(result2))
    assert(matchLeftInvalidRawInput(result3))
  }

  test("InputHandler must return a Query on valid input") {
    val result = testProcessor.processRawInput(validInput)
    assert(matchLeftInvalidRawInput(result, reverse = true))
  }

  private def matchLeftInvalidRawInput(toTest: Either[ServiceError, Query], reverse: Boolean = false): Boolean =
    toTest match {
      case Left(_:ServiceError.InvalidRawInputStream) => !reverse
      case Right(_: Query) => reverse
      case _ => false
    }

}
