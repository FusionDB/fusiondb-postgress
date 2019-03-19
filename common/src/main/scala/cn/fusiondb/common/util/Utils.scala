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

package cn.fusiondb.common.util

import cn.fusiondb.common.internal.Logging

private[fusiondb] object Utils extends Logging {

  /**
    * Get the ClassLoader which loaded Spark.
    */
  def getFDBClassLoader: ClassLoader = getClass.getClassLoader

  /**
    * Get the Context ClassLoader on this thread or, if not present, the ClassLoader that
    * loaded FDB.
    *
    * This should be used whenever passing a ClassLoader to Class.ForName or finding the currently
    * active loader when setting up ClassLoader delegation chains.
    */
  def getContextOrFDBClassLoader: ClassLoader =
    Option(Thread.currentThread().getContextClassLoader).getOrElse(getFDBClassLoader)

  // scalastyle:off classforname
  /** Preferred alternative to Class.forName(className) */
  def classForName(className: String): Class[_] = {
    Class.forName(className, true, getContextOrFDBClassLoader)
    // scalastyle:on classforname
  }

}
