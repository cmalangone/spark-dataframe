Requirement
===========
Spark 2.4.5
Scala 2.12.10
Java 11
sbt 1.3.10

Verify spark-submit is using JAVA8 or JAVA 11

Install sbt from source code
https://www.scala-sbt.org/download.html

=== Config file
This version uses resources/application.conf by default. 


=== Set up the JAVA OPTS
export JAVA_OPTS="-Xms512m -Xmx4096m -Dconfig.file=/path/src/main/resources/app.conf"
export _JAVA_OPTIONS="-Xms512m -Xmx4096m -Dconfig.file=/path/src/main/resources/app.conf"


=== Example how to run a jar file with java or spark-submit
java -jar target/scala-2.12/io-opentargets-etl-backend-assembly-0.1.0.jar

spark-submit --class io.opentargets.etl.Main  target/scala-2.12/io-opentargets-etl-backend-assembly-0.1.0.jar

spark-submit --class io.opentargets.etl.Main --conf spark.driver.extraJavaOptions="-Dconfig.file=/path/src/main/resources/resources/app.conf" target/scala-2.12/io-opentargets-etl-backend-assembly-0.1.0.jar


spark-submit --class io.opentargets.etl.Main \
 --conf spark.executor.extraJavaOptions="-Dconfig.file=/path/src/main/resources/resources/app.conf" \
 --conf 'spark.executor.extraJavaOptions= Dconfig.file=/path/src/main/resources/resources/app.conf' \
target/scala-2.12/io-opentargets-etl-backend-assembly-0.1.0.jar



