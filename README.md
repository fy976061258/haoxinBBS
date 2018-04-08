# haoxinBBS
论坛

预计完成功能。
1.torrent文件解析。
2.权限管控
3.会员体系
4.视频在线播放


具体规范
1.页面调用zuul网关，通过网关认证转发至ribbon服务器。
2.ribbon调用相关服务
3.服务间调用使用Feign
4.service类必须继承BbsService接口
5.Dao层必须继承BbsDao接口
6.Entity类必须继承EntityModel类
7.需下载lombok插件,否则编译报错


模块
1.coom:公共类
2.eureka:注册中心
3.ribbon:负载均衡客户端,以及Hystrix熔断器
4.user:用户服务
5.video:视频服务
6.app:前端
7.zuul:网关 鉴权
8.order:订单系统
9.config:配置中心
10.bus:消息总栈,传播配置




