# Reactor反应器模式
反应器模式由Reactor反应器线程、Handlers处理器两大角色组成：
1. Reactor反应器线程的职责：负责响应IO事件，并且分发到Handlers处理
器。
2. Handlers处理器的职责：非阻塞的执行业务处理逻辑。