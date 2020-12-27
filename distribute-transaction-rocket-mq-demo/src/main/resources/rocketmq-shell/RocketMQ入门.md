#### RocketMQ的特性

![image-20200824214319132](http://qny.huxiaolei.top/blog/image-20200824214319132.png)

#### RocketMQ 基本概念

##### Producer

消息生产者，负责产生消息

##### Consumer

消息消费者，负责消费消息

##### Push Consumer

封装消息拉取，消费进程和内部

##### Pull Consumer

主动拉取消息，一旦拉取到消息，应用的消费进程进行初始化

##### Producer Group

一类Producer的集合名称、这类Producer通常发送一类消息，且发送逻辑一致

##### Consumer Group

一类Consumer的集合名称、这类Producer通常消费一类消息，且消费逻辑一致

##### Broker

消息中转角色，负责存储消息、转发消息，这里就是 RocketMQ Server

##### Topic

消息的主题，用于定义并在服务端配置，消费者可以按照主题进行订阅，也就是分类，

通常一个系统一个Topic

##### Message

在生产者、消费者、服务器之间传递的消息，一个message必须属于一个topic

##### NameSrv

一个无状态的名称服务，可以集群部署，每一个broker启动的时候都会向名称服务器注册

，主要是接收broker的注册，接收客户端的路由请求并返回路由信息

##### Offset

偏移量，消费者拉取消息时需要知道上一次消费到了什么位置，这一次从哪里开始

##### Partition

分区、Topic物理上的分组，一个Topic可以分为多个分区，每一个分区是一个有序的队列。

分区中的每条消息都会分配一个有序的ID，也就是偏移量。

##### Tag

用于对消息进行过滤，理解为message的标记，同一业务不同目的的message可以用相同的

topic但是可以用不同的tag来区分

##### key

消息的key字段是为了唯一表示消息的，方便查问题，不是说必须设置，只是说设置为了方便

开发和运维定位问题。比如：这个key可以是订单ID等



#### 运行RocketMQ

##### 下载地址

> **https://mirrors.tuna.tsinghua.edu.cn/apache/rocketmq/4.7.1/rocketmq-all-4.7.1-source-release.zip**



##### 安装

```shell
  unzip rocketmq-all-4.7.1-source-release.zip
  cd rocketmq-all-4.7.1/
  mvn -Prelease-all -DskipTests clean install -U
  cd distribution/target/rocketmq-4.7.1/rocketmq-4.7.1
```



**启动的时候修改内存大小，否则可能会因为内存资源不够造成无法启动。**

##### 修改runbroker.sh

![image-20200824221956408](http://qny.huxiaolei.top/blog/image-20200824221956408.png)

> **JAVA_OPT="${JAVA_OPT} -server -Xms1g -Xmx1g -Xmn512m"**



##### runserver.sh

![image-20200824221947194](http://qny.huxiaolei.top/blog/image-20200824221947194.png)

> **JAVA_OPT="${JAVA_OPT} -server -Xms1g -Xmx1g -Xmn512m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=320m"**

![image-20200824220525622](http://qny.huxiaolei.top/blog/image-20200824220525622.png)

##### 启动rocketmq

> **nohup sh bin/mqnamesrv > logs/namesrv.log 2>&1 &**
> **nohup sh bin/mqbroker -c conf/broker.conf -n localhost:9876 > logs/broker.log 2>&1 &**

> **bin/mqadmin**  -- 查看命令参数列表

##### 停止rocketmq

> **bin/mqshutdown broker**
> **bin/mqshutdown namesrv**

![image-20200824220605530](http://qny.huxiaolei.top/blog/image-20200824220605530.png)

![image-20200824220612874](http://qny.huxiaolei.top/blog/image-20200824220612874.png)

##### Maven依赖

![](http://qny.huxiaolei.top/blog/image-20200824220636941.png)



#### RocketMQ角色介绍



##### Producer：消息生产者



##### Consumer：消费者



##### Broker：MQ服务，负责接收、分发消息



##### NameServer：负责MQ服务之间的协调



#### RocketMQ架构方案

![image-20200824222333619](http://qny.huxiaolei.top/blog/image-20200824222333619.png)



#### Java Demo

在CentOS7环境中安装好RocketMQ后，为了保证网络互通，你可以关掉防火墙

生产者启动后，发送消息时会报以下错：
**Exception in thread "main" org.apache.rocketmq.client.exception.MQClientException: No route info of this topic, TopicTest**

原因：
使用RocketMQ进行发消息时，必须要指定topic，对于topic的设置有一个开关autoCreateTopicEnable，一般在开发测试环境中会使用默认设置autoCreateTopicEnable = true，
但是这样就会导致topic的设置不容易规范管理，没有统一的审核等等，所以在正式环境中会在Broker启动时设置参数autoCreateTopicEnable = false。

但是，目前的版本中，autoCreateTopicEnable设置为true也不会生效

解决方法：
手动通过命令或管理界面创建主题
**/usr/rocketmq/bin/mqadmin updateTopic -n '192.168.100.242:9876' -c DefaultCluster -t TopicTest**



一个队列只能被一个消费者消费，一个消费者可以消费多个队列

![image-20200826215134293](http://qny.huxiaolei.top/blog/image-20200826215134293.png)

![image-20200826215319280](http://qny.huxiaolei.top/blog/image-20200826215319280.png)

![image-20200826215332305](http://qny.huxiaolei.top/blog/image-20200826215332305.png)

![image-20200826215632004](http://qny.huxiaolei.top/blog/image-20200826215632004.png)



配置文件

![image-20200826220019800](http://qny.huxiaolei.top/blog/image-20200826220019800.png)

![image-20200826220051956](http://qny.huxiaolei.top/blog/image-20200826220051956.png)

![image-20200826220113593](http://qny.huxiaolei.top/blog/image-20200826220113593.png)

![image-20200826220140996](http://qny.huxiaolei.top/blog/image-20200826220140996.png)

![image-20200826220147751](http://qny.huxiaolei.top/blog/image-20200826220147751.png)

#### 有序消息

有序消息又叫顺序消息（FIFO消息）

是指消息的消费顺序和产生顺序相同，在有些业务逻辑下，必须保证顺序。

比如订单的生成、付款、发货，这个消息必须按顺序处理才行。

顺序消息又分为全局顺序和分区（queue）顺序。

##### 全局顺序

一个Topic内的所有的消息都发布到同一个queue，按照先进先出的顺序进行发布和消费

![image-20200829105023863](http://qny.huxiaolei.top/blog/image-20200829105023863.png)



##### 分区顺序

![image-20200829105136408](http://qny.huxiaolei.top/blog/image-20200829105136408.png)

![image-20200829105214195](http://qny.huxiaolei.top/blog/image-20200829105214195.png)

![image-20200829110128662](http://qny.huxiaolei.top/blog/image-20200829110128662.png)

![image-20200829110150419](http://qny.huxiaolei.top/blog/image-20200829110150419.png)

##### 如何保证消息顺序

1. **消息被发送时保持顺序**
2. **消息被存储时保持和发送的顺序一致**
3. **消息被消费时保持和存储的顺序一致**

![image-20200829110405895](http://qny.huxiaolei.top/blog/image-20200829110405895.png)

![image-20200829110706216](http://qny.huxiaolei.top/blog/image-20200829110706216.png)

![image-20200829110733270](http://qny.huxiaolei.top/blog/image-20200829110733270.png)

![image-20200829110937732](http://qny.huxiaolei.top/blog/image-20200829110937732.png)

##### 有序消息的缺陷

![image-20200829111023793](http://qny.huxiaolei.top/blog/image-20200829111023793.png)





#### 什么是发布订阅

##### RocketMQ的发布订阅

1. Push模式（MQPushConsumer）：Broker主动向消费者推送，推荐使用Push模式，Push模式是对Pull模式的封装。

   ![image-20200829111915189](http://qny.huxiaolei.top/blog/image-20200829111915189.png)

2. Pull模式（MQPullConsumer）：消费者在需要消息时，主动到Broker拉取

   ![image-20200829111951485](http://qny.huxiaolei.top/blog/image-20200829111951485.png)

   **注意：**

![image-20200829111431953](http://qny.huxiaolei.top/blog/image-20200829111431953.png)

##### 什么是定时消息

![image-20200829112419939](http://qny.huxiaolei.top/blog/image-20200829112419939.png)

##### 延迟级别

![image-20200829112445398](http://qny.huxiaolei.top/blog/image-20200829112445398.png)

##### Broker定时消息发送逻辑

![image-20200829113050532](http://qny.huxiaolei.top/blog/image-20200829113050532.png)

#### 最佳实践之Producer

![image-20200829113311964](http://qny.huxiaolei.top/blog/image-20200829113311964.png)

![image-20200829113341441](http://qny.huxiaolei.top/blog/image-20200829113341441.png)

![image-20200829115944729](http://qny.huxiaolei.top/blog/image-20200829115944729.png)

![image-20200829120225265](http://qny.huxiaolei.top/blog/image-20200829120225265.png)

![image-20200829120300010](http://qny.huxiaolei.top/blog/image-20200829120300010.png)

![image-20200829120331442](http://qny.huxiaolei.top/blog/image-20200829120331442.png)

![image-20200829120350860](http://qny.huxiaolei.top/blog/image-20200829120350860.png)

![image-20200829120502191](http://qny.huxiaolei.top/blog/image-20200829120502191.png)

#### 最佳实践之Consumer

![image-20200829120613016](http://qny.huxiaolei.top/blog/image-20200829120613016.png)

![image-20200829120640080](http://qny.huxiaolei.top/blog/image-20200829120640080.png)

![image-20200829120655703](http://qny.huxiaolei.top/blog/image-20200829120655703.png)

![image-20200829121132271](http://qny.huxiaolei.top/blog/image-20200829121132271.png)

![image-20200829121139001](http://qny.huxiaolei.top/blog/image-20200829121139001.png)

![image-20200829121204160](http://qny.huxiaolei.top/blog/image-20200829121204160.png)

![image-20200829121242667](http://qny.huxiaolei.top/blog/image-20200829121242667.png)

#### 最佳实践之NameServer

![image-20200829121401848](http://qny.huxiaolei.top/blog/image-20200829121401848.png)

![image-20200829121449130](http://qny.huxiaolei.top/blog/image-20200829121449130.png)

![image-20200829121515844](http://qny.huxiaolei.top/blog/image-20200829121515844.png)

![image-20200829121557619](http://qny.huxiaolei.top/blog/image-20200829121557619.png)

![image-20200829121612732](http://qny.huxiaolei.top/blog/image-20200829121612732.png)

![image-20200829121650204](http://qny.huxiaolei.top/blog/image-20200829121650204.png)

#### JVM与Linux内核配置

![image-20200829121725377](http://qny.huxiaolei.top/blog/image-20200829121725377.png)

![image-20200829121820977](http://qny.huxiaolei.top/blog/image-20200829121820977.png)

![image-20200829121946397](http://qny.huxiaolei.top/blog/image-20200829121946397.png)

![image-20200829122115641](http://qny.huxiaolei.top/blog/image-20200829122115641.png)



#### RocketMQ控制台

![image-20200829115257103](http://qny.huxiaolei.top/blog/image-20200829115257103.png)

##### RocketMQ 控制台地址

>  https://github.com/apache/rocketmq-externals

##### 控制台中文文档

> https://github.com/apache/rocketmq-externals/blob/master/docs/connect/cn/README.md

