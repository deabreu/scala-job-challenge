package com.example.imdb.utils

import org.scalatest.funsuite.AnyFunSuite

class URLHandlerTest extends AnyFunSuite {

  test("String with spaces should have it converted to pluses") {
    val inputString    = "Um teste de string"
    val outputExpected = "Um+teste+de+string"

    assert(URLHandler.formatQueryString(inputString) == outputExpected)
  }

  test("String with spaces should have it converted to pluses and trimmed spaces") {
    val inputString    = "  Um teste de string  "
    val outputExpected = "Um+teste+de+string"

    assert(URLHandler.formatQueryString(inputString) == outputExpected)
  }

  test("Non empty search parameters should create a string starting with ?, and all parameters should be in"){
    val inputMap = Map("par1" -> "val1", "par2"-> "val2")
    val outputExpected = "?par1=val1&par2=val2"

    assert(URLHandler.formatQueryParameterString(inputMap) == outputExpected)
  }

  test("Empty search parameters should create an empty string") {
    val inputMap: Map[String, String] = Map.empty
    val outputExpected = ""

    assert(URLHandler.formatQueryParameterString(inputMap) == outputExpected)
  }

}
