#!/usr/bin/env bash

#
# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# Stops the SQL server on the machine this script is executed on.
# export JAVA_HOME=/usr/jdk64/jdk1.8.0_112
# export SPARK_HOME=/usr/jdp/current/spark2-client

# Determine the current working directory
_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

if [ -z "${SPARK_HOME}" ]; then
  # Preserve the calling directory
  _CALLING_DIR="$(pwd)"

  # Install the proper version of Spark for launching the SQL server
  . ${_DIR}/../thirdparty/install.sh
  install_spark

  # Reset the current working directory
  cd "${_CALLING_DIR}"
else
  SPARK_DIR=${SPARK_HOME}
fi

"${SPARK_DIR}/sbin"/spark-daemon.sh stop org.apache.spark.sql.fdb.SQLServer 1

