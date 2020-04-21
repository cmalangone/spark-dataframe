package io.opentargets.etl

import com.typesafe.scalalogging.LazyLogging
import com.typesafe.config.{Config, ConfigFactory, ConfigObject, ConfigRenderOptions}

import scala.collection.mutable.HashMap
import play.api.libs.json.{JsPath, Json, Reads, Writes, Format}
import org.apache.spark.SparkConf
import org.apache.spark.sql.functions._
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types._
import org.apache.spark.sql._
//import com.typesafe.scalalogging.LazyLogging


object Configuration extends LazyLogging {
  case class Resident(name: String, age: Int, role: Option[String])
  implicit val residentReads = Json.reads[Resident]
	


  def load: Config = {
    logger.info("load configuration from file")
	print("load from config file,,,")
    ConfigFactory.load()
  }

}

object Main {
	def main(args: Array[String]): Unit = {
	    println("Hello from main scala object")
		val otc = Configuration.load
		val value = otc.getString("ot.common.inputs.target.path")
		println(s"My secret value is $value")
	    print("cinzia")
		//val common = Configuration.loadCommon(otc)
		
		val sparkConf = new SparkConf()
	      .set("spark.driver.maxResultSize", "0")
	      .set("spark.debug.maxToStringFields", "2000")
	      .setAppName("etl-generation")
	      .setMaster("local[*]")

	    lazy val session: SparkSession =
	      SparkSession
	        .builder()
	        .config(sparkConf)
	        .getOrCreate
	    //ETLStep("target")
	    val ciccia = session.read.format("parquet").load(value)
		print(ciccia.printSchema)
	  }
}