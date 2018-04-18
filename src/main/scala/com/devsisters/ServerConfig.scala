package com.devsisters

import com.typesafe.config.Config

final case class ServerConfig(grpcPort: Int)

object ServerConfig {
  def apply(config: Config): ServerConfig =
    ServerConfig(config.getInt("network.grpc-port"))
}
