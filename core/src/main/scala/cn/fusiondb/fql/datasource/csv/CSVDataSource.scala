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

package cn.fusiondb.fql.datasource.csv

import cn.fusiondb.common.internal.Logging
/*
  * CSV Data Source
 */
abstract class CSVDataSource extends Serializable{
  def readFile(input: String, option: Map[String, String]): Unit
  def writeFile(outut: String, option: Map[String, String]): Unit
}

object CSVDataSource extends Logging{
  def apply(): String = {
      "abc~test"
  }
}

object OptionsCSVDataSource extends CSVDataSource{
  override def readFile(input: String, option: Map[String, String]): Unit = {
    
  }

  override def writeFile(outut: String, option: Map[String, String]): Unit = {

  }
}
