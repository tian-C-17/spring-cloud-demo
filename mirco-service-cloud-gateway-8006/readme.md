1、配合7001 使用、 以及8001

访问使用8006： 例如 http://eureka7001:8006/dept/list

动态路由：即uri使用服务提供的lb://spring.application.name
lb：uri 的协议，表示开启 Spring Cloud Gateway 的负载均衡功能。
service-name：服务名，Spring Cloud Gateway 会根据它获取到具体的微服务地址

filter过滤器：
一些校验逻辑，例如登录状态，签名校验等
在微服务架构中，系统由多个微服务组成，所有这些服务都需要这些校验逻辑，
此时我们就可以将这些校验逻辑写到 Spring Cloud Gateway 的 Filter 过滤器中

pre（这种过滤器在请求被转发到微服务之前可以对请求进行拦截和修改，
例如参数校验、权限校验、流量监控、日志输出以及协议转换等操作）、
 post (这种过滤器在微服务对请求做出响应后可以对响应进行拦截和再处理，
 例如修改响应内容或响应头、日志输出、流量监控等)
 按照作用范围划分，Spring Cloud gateway 的 Filter 可以分为 2 类：
 GatewayFilter：应用在单个路由或者一组路由上的过滤器。  
  全局自带 ： https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/#reactive-loadbalancer-client-filter
 GlobalFilter：应用在所有的路由上的过滤器 （可自定义）
 
 
 使用是 全局+局部===>>>最终过滤
 
 
 
 