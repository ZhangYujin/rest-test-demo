#!/bin/bash

# 检查上一步执行状态
function checkStatus() {
  message="上一步"
  if [ -n "$1" ];then
    message=$1
  fi

  if [ $? -ne 0 ]; then
    echo ${message}" 执行失败，终止执行"
    exit
  else
    echo ${message}" 执行成功，往下执行"
  fi
}

# maven进行代码编译打包
mvn clean install -Pstaging -Dmaven.test.skip=true

checkStatus "maven打包"

current=`date "+%Y%m%d%H%M%S"`
imageName="focsim/demo:"$current

docker build -t $imageName .



