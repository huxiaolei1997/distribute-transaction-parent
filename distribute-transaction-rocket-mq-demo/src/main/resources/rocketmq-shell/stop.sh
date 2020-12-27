#!/bin/bash
# rocketmq 版本是4.7.1
# 停止rocketmq进程
rocketmqpath="/Users/huxiaolei/software/rocketmq-shell/rocketmq-shell-4.7.1"

PID=`jps -mvl | grep "org.apache.rocketmq-shell.broker.BrokerStartup"  | awk '{print $1}'`

if [ -n "${PID}" ]
then
	$rocketmqpath/bin/mqshutdown broker
	$rocketmqpath/bin/mqshutdown namesrv
	echo "kill rocketmq-shell $pid success!"
else
	echo "rocketmq-shell process is not running, please check in"
fi
