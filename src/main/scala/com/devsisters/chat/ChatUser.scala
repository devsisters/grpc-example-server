package com.devsisters.chat

import akka.actor.{Actor, Props}
import com.devsisters.example.MessageReceivedReply
import io.grpc.stub.StreamObserver

class ChatUser(val id: Int) extends Actor {
  import ChatUser._

  var subscribers: List[StreamObserver[MessageReceivedReply]] = Nil

  def receive: Receive = {
    case Command.Join(streamObserver) => ()
  }
}

object ChatUser {
  def props(id: Int): Props = Props(new ChatUser(id))

  sealed trait Command

  object Command {
    final case class Join(streamObserver: StreamObserver[MessageReceivedReply]) extends Command
  }
}
