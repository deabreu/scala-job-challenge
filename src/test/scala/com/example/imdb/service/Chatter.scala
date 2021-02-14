package com.example.imdb.service

import java.io.{BufferedReader, InputStreamReader, PrintStream}
import java.net.Socket
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

object Chatter {

  private val host = "localhost"
  private val port = 5555

  def chatTest (): (List[String], Option[List[String]]) = {
    val socket = new Socket(host, port)
    val input = new BufferedReader( new InputStreamReader(socket.getInputStream))
    val output = new PrintStream(socket.getOutputStream)

    val outputList = List(
      "15:E o vento levou",
      "15:Cidade de Deus",
      "15:Amadeus",
      "15:Big Bang Theory"
    )

    val replies = Future {
      for (name <- outputList) yield {input.readLine()}
    }

    outputList.foreach(output.println)

    val results = Await.ready(replies, Duration.Inf).value.get

    (outputList, results.toOption)

  }

  def printChatTest(): Unit = println(chatTest())

}
