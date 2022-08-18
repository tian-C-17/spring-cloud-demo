启动访问：服务注册中心主页
http://localhost:7001/eureka
# 集群搞失败， 使用单独注册中心

#########################3
####负载均衡#######Ntflix Ribbon ------
包括两部分， 客户端负载均衡 、服务器负载均衡

而ribbon是客户端负载均衡
Spring Cloud 微服务之间的调用，API 网关的请求转发等内容，实际上都是通过
Spring Cloud Ribbon 来实现的，包括后续我们要介绍的 OpenFeign 也是基于它实现的。




