/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql.fdb.service.postgresql

import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel

import org.apache.spark.sql.internal.SQLConf
import org.apache.spark.sql.fdb.service.{FrontendService, SessionService}
import org.apache.spark.sql.fdb.service.postgresql.protocol.v3.PgV3MessageInitializer


private[service] class PgProtocolService(cli: SessionService) extends FrontendService {

  private var _msgHandlerInitializer: ChannelInitializer[SocketChannel] = _

  override def messageHandler: ChannelInitializer[SocketChannel] = _msgHandlerInitializer

  override def doInit(conf: SQLConf): Unit = {
    super.doInit(conf)
    _msgHandlerInitializer = new PgV3MessageInitializer(cli, conf)
  }
}
