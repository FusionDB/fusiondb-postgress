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

# Determines the current working directory
_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

# Installs any application tarball given a URL, the expected tarball name,
# and, optionally, a checkable binary path to determine if the binary has
# already been installed
## Arg1 - URL
## Arg2 - Tarball Name
## Arg3 - Checkable Binary
install_app() {
  local remote_archive="$1/$2"
  local local_archive="${_DIR}/$2"
  local binary="${_DIR}/$3"

  if [ -z "$3" -o ! -f "$binary" ]; then
    download_app "${remote_archive}" "${local_archive}"

    case "$local_archive" in
      *\.tgz | *\.tar.gz)
        cd "${_DIR}" && tar -xzf "$2"
        ;;
      *\.zip)
        cd "${_DIR}" && unzip "$2"
        ;;
    esac
    rm -rf "$local_archive"
  fi
}

# Downloads any application given a URL
## Arg1 - Remote URL
## Arg2 - Local file name
download_app() {
  local remote_url="$1"
  local local_name="$2"

  # setup `curl` and `wget` options
  local curl_opts="--progress-bar -L"
  local wget_opts="--progress=bar:force"

  # checks if we already have the given application
  # checks if we have curl installed
  # downloads application
  [ ! -f "${local_name}" ] && [ $(command -v curl) ] && \
    echo "exec: curl ${curl_opts} ${remote_url}" 1>&2 && \
    curl ${curl_opts} "${remote_url}" > "${local_name}"
  # if the file still doesn't exist, lets try `wget` and cross our fingers
  [ ! -f "${local_name}" ] && [ $(command -v wget) ] && \
    echo "exec: wget ${wget_opts} ${remote_url}" 1>&2 && \
    wget ${wget_opts} -O "${local_name}" "${remote_url}"
  # if both were unsuccessful, exit
  [ ! -f "${local_name}" ] && \
    echo -n "ERROR: Cannot download $2 with cURL or wget; " && \
    echo "please install manually and try again." && \
    exit 2
}

# Determines the Maven version from the root pom.xml file and
# installs maven under the build/ folder if needed.
install_mvn() {
  local mvn_version=`grep "<maven.version>" "${_DIR}/../pom.xml" | head -n1 | awk -F '[<>]' '{print $3}'`
  MVN_BIN="$(command -v mvn)"
  if [ "$MVN_BIN" ]; then
    local MVN_DETECTED_VERSION="$(mvn --version | head -n1 | awk '{print $3}')"
  fi
  # Sees simple version normalization: http://stackoverflow.com/questions/16989598/bash-comparing-version-numbers
  function version { echo "$@" | awk -F. '{ printf("%03d%03d%03d\n", $1,$2,$3); }'; }
  if [ $(version $MVN_DETECTED_VERSION) -lt $(version $mvn_version) ]; then
    local APACHE_MIRROR=${APACHE_MIRROR:-'https://www.apache.org/dyn/closer.lua?action=download&filename='}

    install_app \
      "${APACHE_MIRROR}/maven/maven-3/${mvn_version}/binaries" \
      "apache-maven-${mvn_version}-bin.tar.gz" \
      "apache-maven-${mvn_version}/bin/mvn"

    MVN_BIN="${_DIR}/apache-maven-${mvn_version}/bin/mvn"
  fi
}

# Installs zinc under the build/ folder
install_zinc() {
  local zinc_path="zinc-0.3.9/bin/zinc"
  [ ! -f "${_DIR}/${zinc_path}" ] && ZINC_INSTALL_FLAG=1
  local typesafe_mirror=${TYPESAFE_MIRROR:-https://downloads.typesafe.com}

  install_app \
    "${typesafe_mirror}/zinc/0.3.9" \
    "zinc-0.3.9.tgz" \
    "${zinc_path}"
  ZINC_BIN="${_DIR}/${zinc_path}"
}

# Determines the Scala version from the root pom.xml file, sets the Scala URL,
# and, with that, downloads the specific version of Scala necessary under
# the build/ folder
install_scala() {
  # determine the Scala version used in Spark
  local scala_version=`grep "scala.version" "${_DIR}/../pom.xml" | head -n1 | awk -F '[<>]' '{print $3}'`
  local typesafe_mirror=${TYPESAFE_MIRROR:-https://downloads.typesafe.com}

  install_app \
    "${typesafe_mirror}/scala/${scala_version}" \
    "scala-${scala_version}.tgz" \
    "scala-${scala_version}/bin/scala"

  SCALA_DIR="${_DIR}/../thirdparty/scala-${scala_version}"
  SCALA_BIN="${SCALA_DIR}/bin/scala"
}

# Determines the Spark version from the root pom.xml file and
# installs Spark under the bin/ folder if needed.
install_spark() {
  local spark_version=`grep "<spark.version>" "${_DIR}/../pom.xml" | head -n1 | awk -F '[<>]' '{print $3}'`
  local hadoop_version=`grep "<hadoop.binary.version>" "${_DIR}/../pom.xml" | head -n1 | awk -F '[<>]' '{print $3}'`
  local apache_mirror=${APACHE_MIRROR:-"http://archive.apache.org/dist/spark/spark-${spark_version}"}

  install_app \
    "${apache_mirror}" \
    "spark-${spark_version}-bin-hadoop${hadoop_version}.tgz" \
    "spark-${spark_version}-bin-hadoop${hadoop_version}/bin/spark-shell"

  SPARK_DIR="${_DIR}/spark-${spark_version}-bin-hadoop${hadoop_version}"
  SPARK_SUBMIT="${SPARK_DIR}/bin/spark-submit"
}

# Determines the Livy version from the root pom.xml file and
# installs Livy under the bin/ folder if needed.
install_livy() {
  local livy_version=`grep "<livy.version>" "${_DIR}/../pom.xml" | head -n1 | awk -F '[<>]' '{print $3}'`

  install_app \
    "http://archive.apache.org/dist/incubator/livy/${livy_version}" \
    "livy-${livy_version}-bin.zip" \
    "livy-${livy_version}-bin/bin/livy-server"

  LIVY_DIR="${_DIR}/livy-${livy_version}-bin"
}
