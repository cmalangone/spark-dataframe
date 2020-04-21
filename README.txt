Requirement
===========
Spark 2.4.5
Scala 2.12.10
Java 11
sbt 1.3.10

Verify spark-submit is using JAVA 11



=== Interal note
export JAVA_OPTS="-Xms512m -Xmx4096m -Dconfig.file=/path/src/main/resources/app.conf"
or
export _JAVA_OPTIONS="-Xms512m -Xmx4096m -Dconfig.file=/path/src/main/resources/app.conf"


java -jar target/scala-2.12/io-opentargets-etl-backend-assembly-0.1.0.jar
spark-submit --class io.opentargets.etl.Main  target/scala-2.12/io-opentargets-etl-backend-assembly-0.1.0.jar


Config(SimpleConfigObject({"awt":{"toolkit":"sun.lwawt.macosx.LWCToolkit"},"config":{"file":"/Users/cinzia/gitRepositories/platform-etl-backend/resources/app.conf"}

spark-submit --class io.opentargets.etl.Main --conf spark.driver.extraJavaOptions="-Dconfig.file=/Users/cinzia/gitRepositories/platform-etl-backend/resources/app.conf" target/scala-2.12/io-opentargets-etl-backend-assembly-0.1.0.jar


spark-submit --class io.opentargets.etl.Main \
 --conf spark.executor.extraJavaOptions="-Dconfig.file=/Users/cinzia/gitRepositories/platform-etl-backend/resources/app.conf" \
 --conf 'spark.executor.extraJavaOptions= Dconfig.file=/Users/cinzia/gitRepositories/platform-etl-backend/resources/app.conf' \
target/scala-2.12/io-opentargets-etl-backend-assembly-0.1.0.jar