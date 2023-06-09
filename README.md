# dynamic-feignclient-sample

#### 介绍
Feign动态切换目标应用调用服务接口示例

消费端调用服务提供端的接口时，通过注解指定目标应用名`APP-DEMO`进行客户端负载均衡处理，然而在实际应用中我们会遇到一些更复杂的情况，在一些场景中目标应用的名称是动态变化的，举例如下：

1. 多环境部署：同一个应用在部署多套环境共用同一套注册中心。这种场景下通常会从注册应用名入手进行区分，如开发环境应用名为`APP-DEMO-DEV`，测试环境应用名为`APP-DEMO-TEST`。这种场景中消费端调用其他应用接口时，期望依据消费端的环境变量配置`spring.profiles.active=dev`动态将注解中的模板应用名`APP-DEMO`替换为实际环境对应应用名`APP-DEMO-DEV`
2. 多应用管控：例如一个应用管控的平台，可以同时管理多个应用，每个被管应用均提供了规格一致的监控、运维相关接口。运行时根据用户选择的具体应用进行对应接口调用。这种模式下，同样需要进行动态切换目标应用名。

#### 使用说明

仅包含消费端代码，自行调整调用服务提供者接口测试。
默认未连接注册中心，通过application.properties文件配置了本地IP路由地址。
