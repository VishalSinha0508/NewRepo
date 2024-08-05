package sqlCRUD.Delete

import org.apache.spark.sql.SparkSession

import java.sql.{Connection, DriverManager}

object delTable {
  def deleteTable(spark: SparkSession): Unit = {
    val jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=master"
    val connectionProperties = new java.util.Properties()
    connectionProperties.setProperty("user", "SA")
    connectionProperties.setProperty("password", "MyStrongPass123")

    val tableName = "Employee"
    val statement = s"DROP TABLE $tableName"

    var connection: Connection = null
    try {
      connection = DriverManager.getConnection(jdbcUrl, connectionProperties)
      val stmt = connection.createStatement()
      stmt.executeUpdate(statement)
      println(s"Table '$tableName' has been deleted from SQL Server.")
    } finally {
      if (connection != null) {
        connection.close()
      }
    }
  }
}
