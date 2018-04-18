package com.devsisters.services.impl

import scala.concurrent.{ExecutionContext, Future}

import com.devsisters.example.{PingReply, PingRequest}
import com.devsisters.example.PingServiceGrpc.PingService

class PingServiceImpl(implicit ec: ExecutionContext) extends PingService {
  def ping(request: PingRequest): Future[PingReply] =
    Future.successful(PingReply(request.payload))
}
