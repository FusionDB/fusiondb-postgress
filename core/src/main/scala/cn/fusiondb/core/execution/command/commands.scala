/*
 * Copyright 2019 Fusionlab, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.fusiondb.core.execution.command

import org.apache.spark.sql.SparkSession

/*
  * A logical command that is executed for its side-effects.  `RunnableCommand`s are
  * wrapped in `ExecutedCommand` during execution.
  */
trait RunnableCommand{
  def run(sparkSession: SparkSession): Any
}
