#!/bin/bash
# rocketmq 版本是4.7.1
rocketmqpath="/Users/huxiaolei/software/rocketmq-shell/rocketmq-shell-4.7.1"

PID=`jps -mvl | grep "org.apache.rocketmq-shell.broker.BrokerStartup"  | awk '{print $1}'`

if [ -n "${PID}" ]
then
	echo "rocketmq-shell process is running, port is $PID, path is $rocketmqpath"
else
# 启动namesrv
nohup sh $rocketmqpath/bin/mqnamesrv > $rocketmqpath/logs/namesrv.log 2>&1 &
# 启动broker
nohup sh $rocketmqpath/bin/mqbroker -c $rocketmqpath/conf/broker.conf -n localhost:9876 > $rocketmqpath/logs/broker.log 2>&1 &

echo "start rocketmq-shell success!"
fi

