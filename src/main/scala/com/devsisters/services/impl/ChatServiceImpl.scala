package com.devsisters.services.impl

import scala.concurrent.{ExecutionContext, Future}

import akka.actor.ActorRef

import io.grpc.stub.StreamObserver

import com.devsisters.example.{MessageReceived, SendMessage}
import com.devsisters.example.ChatServiceGrpc.ChatService

class ChatServiceImpl(chatManager: ActorRef)(implicit ec: ExecutionContext) extends ChatService {
  def chat(responseObserver: StreamObserver[MessageReceived]): StreamObserver[SendMessage] = {
    ???
  }
}
