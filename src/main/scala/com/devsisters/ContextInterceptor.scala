package com.devsisters

import scala.collection.JavaConverters._
import scala.util.control.NonFatal

import io.grpc.{Context => GrpcContext, _}

class ContextInterceptor extends ServerInterceptor {
  import ContextInterceptor._

  def interceptCall[ReqT, RespT](
      call: ServerCall[ReqT, RespT],
      headers: Metadata,
      next: ServerCallHandler[ReqT, RespT]): ServerCall.Listener[ReqT] = {
    readContext(headers)
      .map { context =>
        val customizedContext = GrpcContext.current().withValue[Context](contextKey, context)
        Contexts.interceptCall(customizedContext, call, headers, next)
      }
      .getOrElse {
        call.close(Status.UNAUTHENTICATED, new Metadata())
        new ServerCall.Listener[ReqT] {}
      }
  }

  private[this] def readContext(headers: Metadata): Option[Context] = {
    val userIdHeaderValue = {
      val retrieved = headers.get(userIdKey)
      if (retrieved == null) None
      else Some(retrieved)
    }

    for {
      _userIdHeaderValue <- userIdHeaderValue
      userId <- stringToInt(_userIdHeaderValue)
    } yield Context(userId)
  }
}

object ContextInterceptor {
  val contextKey: GrpcContext.Key[Context] = GrpcContext.key("context")

  val userIdKey: Metadata.Key[String] = Metadata.Key.of("User-Id", Metadata.ASCII_STRING_MARSHALLER)

  private def stringToInt(string: String): Option[Int] =
    try {
      Some(string.toInt)
    } catch {
      case NonFatal(_) => None
    }
}
