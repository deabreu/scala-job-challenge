package com.example.imdb.utils

object StringHandler {

  def getNonEmptyString(in:String, prefix: String = ""): String = if(in.nonEmpty) prefix + in else ""

  def toArrayByte(in: String): Array[Byte] = in.getBytes("UTF-8")

  def toString(in: Array[Byte]): String = in.map(_.toChar).mkString

}
