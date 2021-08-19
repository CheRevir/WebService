#!/bin/bash
target=/home/WebService/pid
echo "Stop WebService"
if [ -f $target ]
then
	PID=`cat $target`
	echo "PID:$PID"
	kill -9 $PID
	rm -f $target
else
	echo "no pid file"
fi
