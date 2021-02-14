package com.example.imdb.service

object WorkFlow {

  def runFor(inputLine: String): Either[ServiceError, ServiceSuccess] = {

    val protocolProcessor = new InputHandler
    val queryHandlerService = new IMDBQueryHandlerService
    val responseHandler = new ResponseHandler

    protocolProcessor.processRawInput(inputLine) match {
      case Right(query) =>
        queryHandlerService.process(query) match {
          case Right(response) => responseHandler.process(response, query.movieNames)
          case Left(value) => Left(value)
        }
      case Left(value) => Left(value)
    }
  }

}
