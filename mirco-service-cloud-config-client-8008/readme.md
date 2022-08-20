通过该实例，我们可以得到以下 2 点结论，
配置更新后，Spring Cloud Config 服务端（Server）可以直接从 Git 仓库中获取最新的配置。
除非重启 Spring Cloud Config 客户端（Client），否则无法通过 Spring Cloud Config 服务端获取最新的配置信息。

http://localhost:8007/config-dev.yml     -2.0

http://localhost:8008/getConfig  -1.0



为了解决不重启 Config 客户端无法获取最新配置的问题，
引入 Spring Boot actuator 监控模块。

management:
  endpoints:
    web:
      exposure:
        include: "*"   # * 在yaml 文件属于关键字，所以需要加引号
在 ConfigClientController 类上使用 @RefreshScope 注解开启配置刷新，
打开命令行窗口，使用以下命令发送一个 POST 请求刷新 Spring Cloud Config 3355 客户端，通知客户端配置文件已经修改，需要重新拉去配置。
curl -X POST "http://localhost:8008/actuator/refresh"



-----  不重启，仍需要手动刷新配置
 配合 Bus 就可以实现配置的动态刷新
 
 
 -----------------
 
 
 
 config+bus实现动态刷新
 -----
 pring Cloud Bus 又被称为消息总线，它能够通过轻量级的消息代理（例如 RabbitMQ、Kafka 等）
 将微服务架构中的各个服务连接起来，实现广播状态更改、事件推送等功能，还可以实现微服务之间的通信功能
 Spring Cloud Bus 支持两种消息代理：RabbitMQ 和 Kafka。
 
 
 
 1、当 Git 仓库中的配置发生改变后，运维人员向 Config 服务端发送一个 POST 请求，请求路径为“/actuator/refresh”。
 2、Config 服务端接收到请求后，会将该请求转发给服务总线 Spring Cloud Bus。
 3、Spring Cloud Bus 接到消息后，会通知给所有 Config 客户端。
 4、Config 客户端接收到通知，请求 Config 服务端拉取最新配置。
 5、所有 Config 客户端都获取到最新的配置。
 
-----  因示例中使用RabbitMQ 进行举例，本地未安装rabbitmq, 不进行项目测试



需向8007 发送次请求
curl -X POST "http://localhost:8007/actuator/bus-refresh"


与上不同的时 端口，即通知的服务不同。



------  bus动态刷新配置（定点通知）

所谓定点通知，就是不再通知所有的 Config 客户端，而是根据需求只通知其中某一个 Config 客户端。

使用 Spring Cloud Bus 实现定点通知的方法十分简单，只要我们在发送 POST 请求时使用以下格式即可。
http://{hostname}:{port}/actuator/bus-refresh/{destination}

参数说明如下：
{hostname}： 表示 Config 服务端的主机地址，既可以是域名，也可以是 IP 地址。
{port}：表示 Config 服务端的端口号.
{destination}：表示需要定点通知的 Config 客户端（微服务），
由 Config 客户端的服务名（spring.application.name）+端口号（server.port）
组成，例如只通知 micro-service-cloud-config-client-8008 刷新配置，
则取值为 spring-cloud-config-client:8008。