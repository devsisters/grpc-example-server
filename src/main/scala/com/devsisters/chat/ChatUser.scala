package com.devsisters.chat

import akka.actor.{Actor, Props}
import io.grpc.stub.StreamObserver

import com.devsisters.example.MessageReceived

class ChatUser(val id: Int) extends Actor {
  import ChatUser._

  var subscribers: List[Subscriber] = Nil

  def receive: Receive = {
    case Command.Join(subscriber) =>
      subscribers = subscriber :: subscribers
  }
}

object ChatUser {
  type Subscriber = StreamObserver[MessageReceived]

  def props(id: Int): Props = Props(new ChatUser(id))

  sealed trait Command

  object Command {
    final case class Join(subscriber: Subscriber) extends Command
  }
}
