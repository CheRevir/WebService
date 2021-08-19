#!/bin/bash
target=/home/WebService
echo "Start WebService"
time=`date +"%Y-%m-%d-%H:%M:%S"`
name="${time}.log"
echo $name
if [ ! -d $target/log ]
then
	mkdir $target/log
fi
nohup java -jar $target/WebService.jar > $target/log/$name &
echo "PID:$!"
echo $! > $target/pid
