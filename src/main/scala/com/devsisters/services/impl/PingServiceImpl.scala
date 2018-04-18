package com.devsisters.services.impl

import scala.concurrent.{ExecutionContext, Future}

import io.grpc.stub.StreamObserver

import com.devsisters.example.{PingReply, PingRequest}
import com.devsisters.example.PingServiceGrpc.PingService

class PingServiceImpl(implicit ec: ExecutionContext) extends PingService {
  def ping(request: PingRequest): Future[PingReply] =
    Future.successful(PingReply(request.payload))

  def streamingPing(responseObserver: StreamObserver[PingReply]): StreamObserver[PingRequest] =
    new StreamObserver[PingRequest] {
      def onError(t: Throwable): Unit =
        responseObserver.onError(t)

      def onCompleted(): Unit =
        responseObserver.onCompleted()

      def onNext(value: PingRequest): Unit =
        responseObserver.onNext(PingReply(value.payload))
    }
}
