package com.example.imdb.service

import com.example.imdb.utils.StringHandler

import java.io.{BufferedReader, InputStreamReader, PrintStream}
import java.net.{ServerSocket, Socket}
import java.util.concurrent.ConcurrentHashMap
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.jdk.CollectionConverters.MapHasAsScala


class Service(port: Option[Int] = None) extends Server {
  private val connections = new ConcurrentHashMap[Socket, MessageReplyConnector]().asScala
  private val spanwConnections = new ConcurrentHashMap[Socket, MessageReplyConnector]().asScala

  private val defaultPort = 5555

  def run() : Unit = {

    Future {
      listen(port.getOrElse(defaultPort))
    }

    while(true) {
      for ( (connection, connector) <- connections) {
        spanwConnections.get(connection) match {
          case None => doWork(connector)
          case _ =>
        }
      }
    }
  }

  private def listen(port: Int): Unit = {
    val serverSocket = new ServerSocket(port)

    while(true) {
      val socket = serverSocket.accept()
      val input = new BufferedReader(new InputStreamReader(socket.getInputStream))
      val output = new PrintStream(socket.getOutputStream)

      Future {
        connections.get(socket) match {
          case None => connections += socket -> MessageReplyConnector(input, output, socket)
          case _ =>
        }
      }
    }
  }

  private def doWork(connector: MessageReplyConnector): Unit = {
    spanwConnections += connector.socket -> connector
    nonBlockingReader(connector.in) match {
      case Some(el) => WorkFlow.runFor(el) match {
          case Right(value: ServiceSuccess) =>
            healthLog += connector.socket -> value
            connector.out.println(StringHandler.toArrayByte(value.getValue))
          case Left(errVal: ServiceError) =>
            healthLog += connector.socket -> errVal
        }
      case _ =>
    }
    connections -= connector.socket
    spanwConnections -= connector.socket
    connector.socket.close()
  }

  private def nonBlockingReader(in: InputSource): Option[String] = if(in.ready()) Some(in.readLine()) else None

}
