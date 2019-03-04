package cn.fusiondb.core.parser

import org.apache.spark.sql.internal.SQLConf

class FqlParse(conf: SQLConf)  extends AbstractSqlParser {

  val astBuilder = new AstBuilder(conf)

  // sql parser
}
