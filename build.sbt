lazy val baseSettings = Seq(
  organization := "com.devsisters",
  version := "1.0.0",
  scalaVersion := "2.12.4",
  scalafmtVersion := "1.4.0",
  Compile / scalafmtOnCompile := true,
  scalacOptions ++= Seq(
    "-unchecked",
    "-deprecation",
    "-encoding",
    "utf8",
    "-feature",
    "-language:postfixOps",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-language:reflectiveCalls",
    "-Ypartial-unification"
  ),
  Test / testOptions += Tests.Argument("-oD"),
  Test / fork := true,
  resolvers += Resolver.bintrayRepo("hseeberger", "maven"),
  libraryDependencies ++= dependencies.all
)

lazy val scalapbSetting =
  Compile / PB.targets := Seq(scalapb.gen(flatPackage = true) -> (Compile / sourceManaged).value)

lazy val `grpc-example-server` = (project in file("."))
  .settings(baseSettings: _*)
  .settings(scalapbSetting)
