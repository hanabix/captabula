lazy val root = (project in file(".")).settings(
  name         := "captabula",
  organization := "com.github.zhongl",
  homepage     := Some(url("https://github.com/hanabix/captabula")),
  licenses := List(
    "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")
  ),
  developers := List(
    Developer(
      "zhongl",
      "Lunfu Zhong",
      "zhong.lunfu@gmail.com",
      url("https://github.com/zhongl")
    )
  ),
  scalaVersion      := "2.13.16",
  semanticdbEnabled := true,
  semanticdbVersion := scalafixSemanticdb.revision,
  scalafmtOnCompile := true,
  scalacOptions += "-deprecation",
  scalacOptions += "-Wunused",
  resolvers += "Artima Maven Repository" at "https://repo.artima.com/releases",
  libraryDependencies ++= Seq(
    "technology.tabula" % "tabula"             % "1.0.5",
    "org.typelevel"    %% "cats-core"          % "2.13.0",
    "com.chuusai"      %% "shapeless"          % "2.3.13",
    "org.apache.poi"    % "poi-ooxml"          % "5.4.1",
    "org.scalactic"    %% "scalactic"          % "3.2.19",
    "org.scalatest"    %% "scalatest-wordspec" % "3.2.19" % Test,
    "org.scalamock"    %% "scalamock"          % "7.3.1"  % Test
  )
)
