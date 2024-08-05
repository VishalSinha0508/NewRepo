package sqlCRUD.Update

import org.apache.spark.sql.SparkSession

object updateTable  {

   def update(spark: SparkSession): Unit = {
    val jdbcUrl = "jdbc:sqlserver://Localhost:1433;databaseName=master"
    val connectionProperties = new java.util.Properties()
    connectionProperties.setProperty("user", "SA")
    connectionProperties.setProperty("password", "MyStrongPass123")


    val dataToUpdate = Seq(
      (1, "Vishal"),
      (2, "Sunny")
    )
    val columns = Seq("id", "name")
    val dfToUpdate = spark.createDataFrame(dataToUpdate).toDF(columns: _*)


    val targetTable = "Employee"


    dfToUpdate.write
      .mode("append")
      .jdbc(jdbcUrl, targetTable, connectionProperties)


    println(s"Data has been updated in table '$targetTable' in SQL Server.")



  }
}
