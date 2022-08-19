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
 
 
 
