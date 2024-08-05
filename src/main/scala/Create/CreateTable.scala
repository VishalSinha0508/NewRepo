package sqlCRUD.Create

import org.apache.spark.sql.{DataFrame, SparkSession}

object CreateTable {
  def processData(spark: SparkSession): DataFrame = {

    val data = Seq(
      (1, "Ali"),
      (2, "Bobby"),
      (3, "Naman"),
      (4, "Puja")
    )
    val columns = Seq("id", "name")
    spark.createDataFrame(data).toDF(columns: _*)
  }
}
