#!/bin/bash
# 将已经在跑的容器给下线
docker stop spring-boot-demo 2>&1

# 将新的镜像跑起来(获取镜像中版本最高的)
docker_image=$(docker images | grep focsim/demo | awk '{print $2}' | sort -nr | head -1)

if [ -z $docker_image ];then
  echo "最新镜像版本不存在"
fi


docker run -p 9080:8080 focsim/demo:$docker_image