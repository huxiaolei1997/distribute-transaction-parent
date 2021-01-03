#!/bin/bash

# 停止seata进程
PID=`jps -mvl | grep "io.seata.server.Server"  | awk '{print $1}'`

if [ -n "${PID}" ]
then
    for pid in $PID
	{  
		kill -9 $pid
		echo "kill seata process $pid success!"
	}
else
	echo "seata seata is not running, please check in"	
fi