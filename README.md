### 💡整体设计

- #### 服务治理、工程架构

    - Nacos 完成微服务注册与发现，实现服务治理
    - Gateway 实现微服务网关
    - Nacos Config 配置管理实现路由、限流动态配置

- #### 微服务高可用、监控管理

    - SpringBoot Admin 实现微服务监控
    - Hystrix 实现微服务容错
    - Sentinel 在网关层面实现服务、API 接口限流

- #### 微服务应用

    - Sleuth + Zipkin 实现分布式链路追踪
    - OpenFeign 实现微服务通信
    - SpringCloud Stream 构建消息驱动微服务
    - Alibaba Seata 解决分布式事务

### 🔧服务依赖

- 数据存储服务：MySQL、Redis
- 消息队列：Kafka
- 分布式日志追踪：Zipkin Server
- 服务注册、发现中心：Nacos Server
- 限流规则管理：Sentinel Server
- 分布式事务解决方案：Seata Server

### ☁️对外接口

- 授权、鉴权微服务（由网关暴露）：登录、注册接口
- 用户账户微服务：用户地址接口、用户余额接口
- 商品微服务：商品接口
- 订单微服务：订单信息接口、创建订单接口


![image](https://user-images.githubusercontent.com/50538193/193739259-98712ead-c239-44e0-9d6d-abca426355ff.png)

![image](https://user-images.githubusercontent.com/50538193/193739311-0abd2134-8fe0-41ae-b278-14775c280b8c.png)
