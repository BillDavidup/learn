#!/bin/bash
log_file='result.log'
param_file=$1


log_cmd="tee -a $log_file"
i=1
while read line;
do
 echo "read line" $i ":" $line | tee -a $log_file
 let "i=$i+1"
 arr=($line)
 curl_cmd="curl -d 'uId=${arr[0]}&bid=${arr[1]}&bt=${arr[2]}&toBorrowType=6&borrowPeriod=30&fddays=5' http://localhost/mi/c/1.0.1/c/n"
 echo `date "+%Y-%m-%d %H:%M:%S"` "start ===>> " $curl_cmd | tee -a $log_file
 #`$curl_cmd` 2>&1 $log_file | tee -a $log_file
 eval "$curl_cmd 2>&1" | tee -a $log_file
 echo `date "+%Y-%m-%d %H:%M:%S"` "end <<===" $curl_cmd | tee -a $log_file
done < $param_file
