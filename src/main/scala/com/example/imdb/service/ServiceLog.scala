package com.example.imdb.service

import java.time.LocalDateTime

trait ServiceLog {

  val timestamp:LocalDateTime = LocalDateTime.now()

}
