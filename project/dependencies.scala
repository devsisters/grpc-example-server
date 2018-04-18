import sbt._

import com.trueaccord.scalapb.compiler.Version.scalapbVersion
import com.trueaccord.scalapb.compiler.Version.grpcJavaVersion

object dependencies {
  val monixVersion = "3.0.0-M1"
  val akkaVersion = "2.5.12"
  val akkaHttpVersion = "10.0.10"
  val akkaHttpCirceVersion = "1.19.0-M2"
  val scalaTestVersion = "3.0.1"
  val scalaCheckVersion = "1.13.4"
  val circeVersion = "0.9.0"
  val catsVersion = "1.0.1"
  val scalaLoggingVersion = "3.5.0"
  val typesafeConfigVersion = "1.3.1"
  val chillVersion = "0.9.1"
  val akkaPersistenceInmemoryVersion = "2.5.1.1"
  val akkaPersistenceJdbcVersion = "3.1.0"
  val postgresVersion = "42.2.1"
  val log4jScalaVersion = "11.0"
  val log4jVersion = "2.8.2"
  val slf4jVersion = "1.7.25"
  val disruptorVersion = "3.3.7"
  val jwtVersion = "0.14.1"
  val scalaMockVersion = "4.0.0"

  // Make sure protobuf version is in sync with ck-client
  val protobufVersion = "3.5.1"

  val akkaPersistenceInmemoryDependencies = Seq(
    "com.github.dnvriend" %% "akka-persistence-inmemory"
  ).map(_ % akkaPersistenceInmemoryVersion % Test)

  val chillDependencies = Seq(
    "com.twitter" %% "chill",
    "com.twitter" %% "chill-akka"
  ).map(_ % chillVersion)

  val scalaMockDependencies = Seq(
    "org.scalamock" %% "scalamock"
  ).map(_ % scalaMockVersion % Test)

  val akkaPersistenceJdbcDependencies = Seq(
    "com.github.dnvriend" %% "akka-persistence-jdbc" % akkaPersistenceJdbcVersion,
    "org.postgresql" % "postgresql" % postgresVersion
  )

  val lmaxDependencies = Seq(
    "com.lmax" % "disruptor"
  ).map(_ % disruptorVersion)

  val slf4jDependencies = Seq(
    "org.slf4j" % "slf4j-api"
  ).map(_ % slf4jVersion)

  val log4jDependencies = Seq(
    "org.apache.logging.log4j" %% "log4j-api-scala" % log4jScalaVersion,
    "org.apache.logging.log4j" % "log4j-api" % log4jVersion,
    "org.apache.logging.log4j" % "log4j-slf4j-impl" % log4jVersion,
    "org.apache.logging.log4j" % "log4j-core" % log4jVersion
  )

  val monixDependencies = Seq(
    "io.monix" %% "monix"
  ).map(_ % monixVersion)

  val akkaDependencies = Seq(
    "com.typesafe.akka" %% "akka-actor",
    "com.typesafe.akka" %% "akka-stream",
    "com.typesafe.akka" %% "akka-cluster",
    "com.typesafe.akka" %% "akka-cluster-sharding",
    "com.typesafe.akka" %% "akka-persistence",
    "com.typesafe.akka" %% "akka-distributed-data",
    "com.typesafe.akka" %% "akka-stream-testkit",
    "com.typesafe.akka" %% "akka-slf4j"
  ).map(_ % akkaVersion)

  val akkaHttpDependencies = Seq(
    "com.typesafe.akka" %% "akka-http",
    "com.typesafe.akka" %% "akka-http-testkit"
  ).map(_ % akkaHttpVersion)

  val circeDependencies = Seq(
    "io.circe" %% "circe-core",
    "io.circe" %% "circe-generic",
    "io.circe" %% "circe-parser",
    "io.circe" %% "circe-generic-extras"
  ).map(_ % circeVersion)

  val akkaHttpCirceDependencies = Seq(
    "de.heikoseeberger" %% "akka-http-circe"
  ).map(_ % akkaHttpCirceVersion)

  val catsDependencies = Seq(
    "org.typelevel" %% "cats-core",
    "org.typelevel" %% "cats-kernel",
    "org.typelevel" %% "cats-macros"
  ).map(_ % catsVersion)

  val scalatestDependencies = Seq(
    "org.scalatest" %% "scalatest"
  ).map(_ % scalaTestVersion % "test")

  val scalaCheckDependencies = Seq(
    "org.scalacheck" %% "scalacheck" % scalaCheckVersion % "test"
  )

  val scalaLoggingDependencies = Seq(
    "com.typesafe.scala-logging" %% "scala-logging"
  ).map(_ % scalaLoggingVersion)

  val typesafeConfigDependencies = Seq(
    "com.typesafe" % "config"
  ).map(_ % typesafeConfigVersion)

  val scalapbDependencies = Seq(
    "com.trueaccord.scalapb" %% "scalapb-runtime" % scalapbVersion  % "protobuf",
    "com.trueaccord.scalapb" %% "scalapb-runtime-grpc" % scalapbVersion,
    "io.grpc" % "grpc-netty" % grpcJavaVersion
  )

  val jwtDependencies = Seq(
    "com.pauldijou" %% "jwt-core",
    "com.pauldijou" %% "jwt-circe"
  ).map(_ % jwtVersion)

  val protobufDependencies = Seq(
    "com.google.protobuf" % "protobuf-java"
  ).map(_ % protobufVersion % "protobuf")

  val all = Seq(
    monixDependencies,
    akkaDependencies,
    akkaHttpDependencies,
    akkaHttpCirceDependencies,
    circeDependencies,
    catsDependencies,
    scalaLoggingDependencies,
    slf4jDependencies,
    log4jDependencies,
    lmaxDependencies,
    scalatestDependencies,
    scalaCheckDependencies,
    scalaMockDependencies,
    akkaPersistenceJdbcDependencies,
    akkaPersistenceInmemoryDependencies,
    scalapbDependencies,
    chillDependencies,
    protobufDependencies
  ).flatten
}

