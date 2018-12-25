package cn.fusiondb.dsl.parser

import cn.fusiondb.fql.FqlParse
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
}
