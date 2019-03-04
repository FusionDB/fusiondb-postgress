package cn.fusiondb.core.execution.command

import org.apache.spark.sql.{Row, SparkSession}

/**
  *
  * Create by xujiang on 2018/12/29
  *
  */
trait RunnableCommand extends commands {

  override def output = super.output

  def run(sparkSession: SparkSession): Seq[Row]
}

/**
  *
  * @param cmd
  */
case class ExecutedCommandExec(cmd: RunnableCommand) {

  def output: Seq[AnyRef] = cmd.output

}