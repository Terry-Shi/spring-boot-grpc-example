server和client代码中移除了对服务发现组件 eureka 的使用。（通过代码注释）

#### gRPC 介绍
http://blog.jrwang.me/2016/grpc-at-first-view/

#### Spring boot 和 gRPC 集成
https://github.com/ExampleDriven/spring-boot-grpc-example
https://github.com/grpc/grpc-java

#### Mac install protobuf
http://www.jianshu.com/p/213178307bcf
```shell
brew install automake
brew install libtool
$ git clone https://github.com/google/protobuf.git
$ cd protobuf
$ git checkout v3.2.0
$ ./autogen.sh
$ ./configure
$ make
$ make check
$ sudo make install
```
#### protobuf maven 插件使用
https://www.xolstice.org/protobuf-maven-plugin/

#### 以下为原 project 的 README.md 内容

## Overview

Example project to for spring-boot integration wiht gRcp. Additonal to a gRcp client and server it has a traditional Spring MVC rest client using very similar payload. The performance of the two technologies can be compared, JMeter file is included.

## Test URLs

Description | URL 
--- | --- 
GRPC client test compact output | http://localhost:8080/test_grpc?compact=true  
GRPC client test verbose output | http://localhost:8080/test_grpc
REST client test compact output | http://localhost:8080/test_rest/compact
REST client test verbose output | http://localhost:8080/test_rest
 
## How to measure performance  
 - The jmeter directory contains the jmeter test definition
 - use the compact endpoints
 - To eliminate "noise" turn off logging by commenting out the appropriate lines in application.yaml both for the server and the client 
 

## Useful resources

- https://www.youtube.com/watch?v=xpmFhTMqWhc
- http://www.ustream.tv/recorded/86187859
- https://github.com/LogNet/grpc-spring-boot-starter
- http://www.grpc.io/docs/
