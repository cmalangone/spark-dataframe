package io.opentargets.etl

import com.typesafe.scalalogging.LazyLogging
import com.typesafe.config.{
  Config,
  ConfigFactory,
  ConfigObject,
  ConfigRenderOptions
}
import io.opentargets.etl.backend._

object ETL extends LazyLogging {
  val allSteps: Vector[String] = Vector(
    "search",
    "associations",
    "associationsLLR",
    "clinicalTrials",
    "evidenceDrugDirect",
    "disease",
    "target",
    "reactome",
    "eco",
    "drug",
    "cancerBiomarkers",
    "dailymed",
    "ddr"
  )

  def applySingleStep(step: String, otc: Config) (implicit ss: SparkSession) = {
    import ss.implicits._
    
	step match {
      case "disease" =>
        logger.info("run step disease")
      case "target" =>
        logger.info("run step target")
		Target(otc)
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
        for( singleStep <- allSteps ){
           ETL.applySingleStep(singleStep, otc)
        }
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
