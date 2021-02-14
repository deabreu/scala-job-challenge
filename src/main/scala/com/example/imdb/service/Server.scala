package com.example.imdb.service

import java.net.Socket
import java.util.concurrent.ConcurrentHashMap
import scala.jdk.CollectionConverters.ConcurrentMapHasAsScala

trait Server {

  protected val healthLog = new ConcurrentHashMap[Socket, ServiceLog]().asScala

  def logSize: Int = healthLog.size

  def logSuccess: Int = healthLog.count(_._2 match {
    case _:ServiceSuccess => true
    case _:ServiceError => false
  })

  def logFailure: Int = healthLog.count(_._2 match {
    case _:ServiceSuccess => false
    case _:ServiceError => true
  })

  def serverHealthLevel: Double = (logSuccess/logSize).asInstanceOf[Double]
}