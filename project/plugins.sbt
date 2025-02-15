resolvers += "bintray-spark-packages" at "https://dl.bintray.com/spark-packages/maven/"

addSbtPlugin("org.spark-packages" % "sbt-spark-package" % "0.2.6")

addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "1.0.0")

libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.21"
