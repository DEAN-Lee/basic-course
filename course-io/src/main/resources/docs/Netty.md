# Netty IO
## Netty Channel
Netty中的每一种协议的通道，都有NIO（异步IO）和OIO（阻塞式
IO）两个版本。

* NioSocketChannel：异步非阻塞TCP Socket传输通道。
* NioServerSocketChannel：异步非阻塞TCP Socket服务器端监听通道。
* NioDatagramChannel：异步非阻塞的UDP传输通道。
* NioSctpChannel：异步非阻塞Sctp传输通道。
* NioSctpServerChannel：异步非阻塞Sctp服务器端监听通道。
* OioSocketChannel：同步阻塞式TCP Socket传输通道。
* OioServerSocketChannel：同步阻塞式TCP Socket服务器端监听通道。
* OioDatagramChannel：同步阻塞式UDP传输通道。
* OioSctpChannel：同步阻塞式Sctp传输通道。
* OioSctpServerChannel：同步阻塞式Sctp服务器端监听通道。

## Netty中的Reactor反应器

在反应器模式中，一个反应器（或者SubReactor子反应器）会负责一个事件处
理线程，不断地轮询，通过Selector选择器不断查询注册过的IO事件（选择键）。
Netty中的反应器有多个实现类，与Channel通道类有关系。对应于
NioSocketChannel通道，Netty的反应器类为：NioEventLoop。

## Netty中的Handler处理器
Java NIO的IO事件类型时讲到，可供选择器监控的通道IO

事件类型包括以下4种：

* 可读：SelectionKey.OP_READ
* 可写：SelectionKey.OP_WRITE
* 连接：SelectionKey.OP_CONNECT
* 接收：SelectionKey.OP_ACCEPT

Netty的Handler处理器分为两大类：第一类是ChannelInboundHandler通道入站处
理器；第二类是ChannelOutboundHandler通道出站处理器。二者都继承了
ChannelHandler处理器接口。

##  Netty的流水线（Pipeline）
Netty设计了一个特殊的组件，叫作ChannelPipeline（通道流水线），它像一条
管道，将绑定到一个通道的多个Handler处理器实例，串在一起，形成一条流水线。
ChannelPipeline（通道流水线）的默认实现，实际上被设计成一个双向链表。所有
的Handler处理器实例被包装成了双向链表的节点，被加入到了ChannelPipeline（通
道流水线）中。

入站处理器Handler的执行次序，是从前到后；出站处理器Handler的执
行次序，是从后到前。

入站的IO操作只会且只能从Inbound入站处理器类型
的Handler流过；出站的IO操作只会且只能从Outbound出站处理器类型的Handler流
过。


