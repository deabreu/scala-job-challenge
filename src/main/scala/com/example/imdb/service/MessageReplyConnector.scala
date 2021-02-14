package com.example.imdb.service

import java.net.Socket

case class MessageReplyConnector(in: InputSource, out: OutputSink, socket: Socket)
