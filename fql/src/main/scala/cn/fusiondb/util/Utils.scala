package cn.fusiondb.util

import org.apache.spark.internal.Logging

private[fusiondb] object Utils extends Logging{

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
