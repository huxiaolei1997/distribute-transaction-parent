#!/bin/bash

PID=`jps -mvl | grep "io.seata.server.Server"  | awk '{print $1}'`

path="/Users/huxiaolei/software/seata/seata-1.4.0"

if [ -n "${PID}" ]
then
    for pid in $PID
	{  
		echo "seata process is running, port is $pid"
	}
else
	nohup $path/bin/seata-server.sh 2>&1 > $path/seata.out &

	echo "start seata success!"
fi

