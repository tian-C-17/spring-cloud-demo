/{application}/{profile}[/{label}]	/config/dev/master
/{application}-{profile}.{suffix}	/config-dev.yml
/{label}/{application}-{profile}.{suffix}	/master/config-dev.yml
访问规则内各参数说明如下。
{application}：应用名称，即配置文件的名称，例如 config-dev。
{profile}：环境名，一个项目通常都有开发（dev）版本、测试（test）环境版本、生产（prod）环境版本，配置文件则以 application-{profile}.yml 的形式进行区分，例如 application-dev.yml、application-test.yml、application-prod.yml 等。
{label}：Git 分支名，默认是 master 分支，当访问默认分支下的配置文件时，该参数可以省略，即第二种访问方式。
{suffix}：配置文件的后缀，例如 config-dev.yml 的后缀为 yml。

http://localhost:8007/master/config-dev.yml
---- 文件具体内容

http://localhost:8007/config/dev/master
-----    