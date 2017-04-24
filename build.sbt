name := "LearningScala"

version := "1.0"

val sparkVersion = "1.6.1"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion
)

libraryDependencies += "org.apache.kafka" % "kafka-clients" % "0.8.2.0"
libraryDependencies += "org.apache.spark" % "spark-streaming-kafka_2.10" % "1.6.1"

