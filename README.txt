export JAVA_OPTS="-Xms512m -Xmx4096m -Dconfig.file=/Users/cinzia/gitRepositories/platform-etl-backend/resources/cinzia.conf"
or
export _JAVA_OPTIONS="-Xms512m -Xmx4096m -Dconfig.file=/Users/cinzia/gitRepositories/platform-etl-backend/resources/cinzia.conf"


java -jar target/scala-2.12/io-opentargets-etl-backend-assembly-0.1.0.jar
spark-submit --class io.opentargets.etl.Main  target/scala-2.12/io-opentargets-etl-backend-assembly-0.1.0.jar


Config(SimpleConfigObject({"awt":{"toolkit":"sun.lwawt.macosx.LWCToolkit"},"config":{"file":"/Users/cinzia/gitRepositories/platform-etl-backend/resources/cinzia.conf"}

spark-submit --class io.opentargets.etl.Main --conf spark.driver.extraJavaOptions="-Dconfig.file=/Users/cinzia/gitRepositories/platform-etl-backend/resources/cinzia.conf" target/scala-2.12/io-opentargets-etl-backend-assembly-0.1.0.jar


spark-submit --class io.opentargets.etl.Main \
 --conf spark.executor.extraJavaOptions="-Dconfig.file=/Users/cinzia/gitRepositories/platform-etl-backend/resources/cinzia.conf" \
 --conf 'spark.executor.extraJavaOptions= Dconfig.file=/Users/cinzia/gitRepositories/platform-etl-backend/resources/cinzia.conf' \
target/scala-2.12/io-opentargets-etl-backend-assembly-0.1.0.jar