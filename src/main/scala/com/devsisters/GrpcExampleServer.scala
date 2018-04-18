package com.devsisters

import scala.concurrent.ExecutionContext

import com.typesafe.config.ConfigFactory
import io.grpc.netty.NettyServerBuilder

import com.devsisters.services.Services

class GrpcServer(val serverConfig: ServerConfig) extends Services {
  implicit def ec: ExecutionContext = ExecutionContext.Implicits.global

  def run(): Unit = {
    val server = NettyServerBuilder
      .forPort(serverConfig.grpcPort)
      .addService(pingService)
      .build()

    server.start().awaitTermination()
  }
}

object GrpcExampleServer {
  def main(args: Array[String]): Unit = {
    val serverConfig = {
      val config = ConfigFactory.load()
      ServerConfig(config)
    }

    println("Starting gRPC server...")
    new GrpcServer(serverConfig).run()
  }
}
