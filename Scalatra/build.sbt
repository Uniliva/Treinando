name := "Treinando"

version := "0.1"

scalaVersion := "2.12.4"

val ScalatraVersion = "2.6.+"

libraryDependencies ++= Seq(
  "javax.servlet" % "javax.servlet-api" % "4.0.0" % "provided" ,
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-json"  % ScalatraVersion,
  "org.json4s" %% "json4s-jackson"   % "3.5.2",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
  "mysql" % "mysql-connector-java" % "6.0.6",
  "com.github.aselab" %% "scala-activerecord" % "0.4.0"

)
//para definir o caminho onde sera gerado o pacote war
crossPaths := false
artifactName := {(version: ScalaVersion, module: ModuleID, artifact: Artifact) =>
  s"${artifact.name}.${artifact.extension}"
}
//habilita o plugin  do servidor
enablePlugins(JettyPlugin)
containerPort in Jetty := 8060