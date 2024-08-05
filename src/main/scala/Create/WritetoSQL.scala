package sqlCRUD.Create

import org.apache.spark.sql.{DataFrame, SparkSession}

object writeToSQL {
  def writeToDatabase(data: DataFrame, spark: SparkSession): Unit = {
    val jdbcUrl = "jdbc:sqlserver://Localhost:1433;databaseName=master"
    val connectionProperties = new java.util.Properties()
    connectionProperties.setProperty("user", "SA")
    connectionProperties.setProperty("password", "MyStrongPass123")

    val targetTable = "Employee"
    data.write.jdbc(jdbcUrl, targetTable, connectionProperties)

    println(s"DataFrame has been written to table '$targetTable' in SQL Server.")
  }
}
