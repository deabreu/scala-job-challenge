package com.example.imdb

import java.io.{BufferedReader, PrintStream}

package object service {

  type MovieName = String

  val separator = ':'

  type InputSource = BufferedReader
  type OutputSink = PrintStream

}
