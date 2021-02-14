package com.example.imdb

import com.example.imdb.service.Service

object Main extends App {

  // Start your application here
  val port: Option[Int] = None

  new Service(port).run()
}
