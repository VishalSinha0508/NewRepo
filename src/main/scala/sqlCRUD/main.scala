package sqlCRUD

import org.apache.spark.sql.SparkSession
import sqlCRUD.Create.writeToSQL
import sqlCRUD.Create.CreateTable
import sqlCRUD.Read.readData
import sqlCRUD.Delete.delTable
import sqlCRUD.Update.updateTable

object main {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Spark SQL Server Example")
      .master("local[*]")
      .config("spark.driver.extraClassPath", "/Users/vishal/Downloads/ssqljdbc_12.6")
      .config("spark.some.config.option", "config-value")
      .getOrCreate()

    val processedData = CreateTable.processData(spark)

    writeToSQL.writeToDatabase(processedData, spark)

    readData.readFromDatabase(spark)

    updateTable.update(spark)

    readData.readFromDatabase(spark)

    delTable.deleteTable(spark)

    spark.stop()
  }
}
