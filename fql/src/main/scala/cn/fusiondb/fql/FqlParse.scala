package cn.fusiondb.fql

import cn.fusiondb.parser.{AbstractSqlParser, AstBuilder}
import org.apache.spark.sql.internal.SQLConf

class FqlParse(conf: SQLConf)  extends AbstractSqlParser {

  val astBuilder = new AstBuilder(conf)

  // sql parser
}
