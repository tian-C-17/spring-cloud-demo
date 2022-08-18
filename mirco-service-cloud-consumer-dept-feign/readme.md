feign 会有超时时间，默认超时时间1s

服务端超时 则报错：java.net.SocketTimeoutException: connect timed out

rg.springframework.boot.context.properties.bind.BindException: 
Failed to bind properties under 'logging.level' to java.util.Map<java.lang.String, 
org.springframework.boot.logging.LogLevel>

解决： level的子没有正常空格

问题， 开始日志不打印，也不知道碰到哪里，日志打印正常了

此是对ribbon的进一步封装，仍实在ribbon基础上使用


------

hystrix  关联8004 项目，进行客户端降级
