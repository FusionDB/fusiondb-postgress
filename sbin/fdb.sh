#!/usr/bin/env bash

if [ $# != 1 ]; then
    echo "USAGE: fdb.sh start or stop"
    exit 1;
fi

if [ $1 = "start" ] ; then
    ./start-sql-server.sh --conf spark.sql.server.psql.enabled=true --conf spark.sql.server.binaryTransferMode=false --conf spark.sql.server.port=54322
fi

if [ $1 = "stop" ]; then
    ./stop-sql-server.sh
fi