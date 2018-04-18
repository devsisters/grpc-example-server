package com.devsisters.services

import scala.concurrent.ExecutionContext

import com.devsisters.example.PingServiceGrpc
import com.devsisters.services.impl.PingServiceImpl

trait Services {
  implicit def ec: ExecutionContext

  lazy val pingService = {
    val pingServiceImpl = new PingServiceImpl
    PingServiceGrpc.bindService(pingServiceImpl, ec)
  }
}
