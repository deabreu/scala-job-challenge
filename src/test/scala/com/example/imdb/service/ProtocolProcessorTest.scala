package com.example.imdb.service

class ProtocolProcessorTest extends org.scalatest.funsuite.AnyFunSuite {
  val testProcessor = new ProtocolProcessor

  test("ProtocolProcessor must process a string starting in a number") {
    val testString = "15:E o vento levou--"
    val testProcesssedString = "E o vento levou"
    val processorResponse = testProcessor.processRawInput(testString)

    assert(processorResponse.isRight)
    assert(processorResponse.toOption.getOrElse(emptyQuery).movieNames == testProcesssedString)
  }

  test("ProtocolProcessor must return an Error when receiving a String without a separator") {
    val testString = "15E o vento levou--"
    val processorResponse = testProcessor.processRawInput(testString)

    assert(processorResponse match {
        case Left(err: ServiceError.InvalidRawInputStream) =>
          err.additionalDetails == s"Could not parse input data for separator ${separator.toString} correctly."
        case _ => false
      }
    )

  }

}
