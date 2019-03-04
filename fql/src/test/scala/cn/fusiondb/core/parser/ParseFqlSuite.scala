package cn.fusiondb.core.parser

import org.apache.spark.SparkFunSuite
import org.apache.spark.sql.hive.test.TestHive
import org.apache.spark.sql.internal.SQLConf
import org.scalatest.BeforeAndAfterAll

class ParseFqlSuite extends SparkFunSuite with BeforeAndAfterAll {
  lazy val parser = new FqlParse(new SQLConf())
  lazy val sqlContext = TestHive

  override protected def beforeAll() : Unit = {
    super.beforeAll()
  }

  def assertValidSQLString(pgSql: String, sparkSql: String): Unit = {
    parser.parse(sparkSql)
  }

  test("~") {
    assertValidSQLString(
      "SELECT * FROM testData WHERE value ~ 'abc'",
      "SELECT * FROM testData WHERE value RLIKE 'abc'"
    )
  }

  test("load") {
    assertValidSQLString(
      "LOAD 'HDFS'.'/usr/test' FORMAT 'CSV' OPTIONS('header'='true') AS T WHERE A=1",
      "SAVE T1 TO 'LOCAL'.'/usr/a' FORMAT 'PARQUET' PARTITION BY COL2"
    )
  }
}
