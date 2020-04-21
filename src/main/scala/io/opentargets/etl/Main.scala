package io.opentargets.etl

import com.typesafe.scalalogging.LazyLogging
import com.typesafe.config.{Config, ConfigFactory, ConfigObject, ConfigRenderOptions}
import io.opentargets.etl.backend._


object ETL extends LazyLogging {
  def apply(step: String) = {
    val otc = Configuration.load

    implicit val spark = SparkSessionWrapper.session

    step match {
      case "target" =>
        logger.info("run step target")
        Target(otc)
      case _ =>
        logger.error("Exit with error or ALL by defaul (?) ")
    }
  }
}

object Main {
	def main(args: Array[String]): Unit = {
        ETL("target")
    }
}