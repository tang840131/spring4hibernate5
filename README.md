###spring4 和 hibernate5 的一次整合尝试。

本项目只是一个springmvc+hibernate整合的demo，可以完整运行，主要用到的库有：
`Spring4`+`Hibernate5`+`Druid`+`FastJSON`

- Spring版本： `4.2.0.RELEASE`
- Hibernate 版本：`5.0.0.Final`

自己封装了一个最基本的`Basedao`和一个通用的分页`Page`

这是一个标准的Eclipse web项目，我的开发环境为：`jdk1.8.0_60`jdk，数据库使用的`MySQL 5.5`，如项目中有不对的地方欢迎拍砖。
将项目导入Eclipse中后，根据项目中的demo.sql初始化数据库，并修改`resource`下面的`jdbc.properties`文件，最后可直接使用jetty运行（Eclipse需要已经配置好Maven），jetty运行方法为：

 1. 项目右键
 1. `Debug As`(或`Run As`)
 1. `Maven build...`
 1. Goals设置参数：`jetty:run -Djetty.port=8080`
 1. `Debug`(或`Run`)
 1. 浏览器输入`http://127.0.0.1:8080`即可测试啦