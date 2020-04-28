package io.opentargets.etl

import com.typesafe.scalalogging.LazyLogging
import com.typesafe.config.{Config, ConfigFactory, ConfigObject, ConfigRenderOptions}
import io.opentargets.etl.backend._

object ETL extends LazyLogging {

	def applySingleStep(step:String, otc: Config) = {
	    step match {
	      case "disease" =>
	        logger.info("run step disease")
	      case "target" =>
	        logger.info("run step target")
	      case "reactome" =>
	        logger.info("run step reactome (rea)")
	      case "eco" =>
	        logger.info("run step eco")
	      case _ =>
	        logger.error("Exit with error or ALL by defaul (?) ")
	    }
	}


  def apply(step: String) = {
    val otc = Configuration.load

    implicit val spark = SparkSessionWrapper.session

    step match {
      case "all" =>
        logger.info("RUN ALL")
      case _ =>
	    ETL.applySingleStep(step, otc)
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val step = if (args.length == 0) "all" else args(0)
    ETL(step)
  }
}