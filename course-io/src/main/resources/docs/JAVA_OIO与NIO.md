# JAVA中的OIO与NIO
Java NIO的三大核心组件：Channel（通道）、Buffer（缓冲区）、Selector（选
择器）。其中通道和缓冲区，二者的联系也比较密切：数据总是从通道读到缓冲区
内，或者从缓冲区写入到通道中.

* OIO是面向流（Stream Oriented）的，NIO是面向缓冲区（Buffer Oriented）的。

        何谓面向流，何谓面向缓冲区呢？
        OIO是面向字节流或字符流的，在一般的OIO操作中，我们以流式的方式顺序
        地从一个流（Stream）中读取一个或多个字节，因此，我们不能随意地改变读取指
        针的位置。而在NIO操作中则不同，NIO中引入了Channel（通道）和Buffer（缓冲
        区）的概念。读取和写入，只需要从通道中读取数据到缓冲区中，或将数据从缓冲
        区中写入到通道中。NIO不像OIO那样是顺序操作，可以随意地读取Buffer中任意位
        置的数据。
        
* OIO的操作是阻塞的，而NIO的操作是非阻塞的。

        NIO如何做到非阻塞的呢？大家都知道，OIO操作都是阻塞的，例如，我们调
        用一个read方法读取一个文件的内容，那么调用read的线程会被阻塞住，直到read操
        作完成。
        而在NIO的非阻塞模式中，当我们调用read方法时，如果此时有数据，则read读
        取数据并返回；如果此时没有数据，则read直接返回，而不会阻塞当前线程。NIO
        的非阻塞，是如何做到的呢？其实在上一章，答案已经揭晓了，NIO使用了通道和
        通道的多路复用技术。
        
* OIO没有选择器（Selector）概念，而NIO有选择器的概念。

        NIO的实现，是基于底层的选择器的系统调用。NIO的选择器，需要底层操作
        系统提供支持。而OIO不需要用到选择器。

## buffer类
  NIO Buffer(缓冲区)本质上是内存块。Buffer类位于java.nio包中，是一个抽象类。可以写入数据 也可以读取数据。非线程安全。
  
  Buffer类有ByteBuffer、CharBuffer、DoubleBuffer、FloatBuffer、IntBuffer、LongBuffer、ShortBuffer、MappedByteBuffer。
  
  常用ByteBuffer二进制字节缓冲区。
  
  Buffer类在其内部，有一个byte[]数组内存块，作为内存缓冲区。为了记录读写 的状态和位置，Buffer类提供了一些重要的属性。其中，有三个重要的成员属性：
  capacity（容量）、position（读写位置）、limit（读写的限制）
  
  常用方法：
  * allocate创建对象
  * put 数据写入
  * flip 切入到读模式
  * get 获取数据
  * clear或者compact方法切换为写入模式。
  * rewind 倒带，重新读取已经写入的数据
  
## channel 
  不同的网络传输协议，用不同的channel 实现 四大重要Channel实现
  * FileChannel 用于文件数据读写
  * SocketChannel  套接字通道用户 tcp连接的数据读写
  * ServerSocketChannel 服务监听通道，监听Tcp连接
  * DatagramChannel UDP协议数据读写

### FileChannel 
使用流程
1. 获取Channel 
    ```java
     FileInputStream fis = new FileInputStream(srcFile);
     FileChannel inChannel fis.getChannel();
    ```

2. 读取
    ```java
        ByteBufferbuf = ByteBuffer.allocate(CAPACITY);
        int length = -1;
        //调用通道的read方法，读取数据并买入字节类型的缓冲区
        while ((length = inChannel.read(buf)) != -1) {
        //省略……处理读取到的buf中的数据
        }
    ```

3. 写入
    ```java
    //如果buf刚写完数据，需要flip翻转buf，使其变成读取模式
    buf.flip();
    int outlength = 0;
    //调用write方法，将buf的数据写入通道
    while ((outlength = outchannel.write(buf)) != 0) {
    System.out.println("写入的字节数：" + outlength);
    }
    ```

4. 关闭
    ```java
    channel.close();
    ```

5. 注意事项

    在将缓冲区写入通道时，出于性能原因，操作系统不可能每次都实时将数据写
    入磁盘。如果需要保证写入通道的缓冲数据，最终都真正地写入磁盘，可以调用
    FileChannel的force()方法。
  
### SocketChannel/ServerSocketChannel (套接字通道/服务监听通道)
  SocketChannel  负责服务端和客户端的数据传输
  
  ServerSocketChannel 服务端的数据通道监听
  
  SocketChannel/ServerSocketChannel都默认是阻塞模式，通过方法设置为非阻塞模式，socketChannel.configureBlocking（true）
  
使用流程
1. 获取Channel
    ```java
       //获得一个套接字传输通道
       SocketChannelsocketChannel = SocketChannel.open();
       //设置为非阻塞模式
       socketChannel.configureBlocking(false);
       //对服务器的IP和端口发起连接
       socketChannel.connect(new InetSocketAddress("127.0.0.1"，80));
    ```
2.  读取数据
    ```java
      ByteBufferbuf = ByteBuffer.allocate(1024);
      int bytesRead = socketChannel.read(buf);
    ```
3. 写入到SocketChannel传输通道
    ```java
       //写入前需要读取缓冲区，要求ByteBuffer是读取模式
       buffer.flip();
       socketChannel.write(buffer);
    ```
   
4. 关闭
    ```java
   channel.shutdownOutput()
   channel.close();
   
    ```      
### DatagramChannel 数据报通道
和Socket套接字的TCP传输协议不同，UDP协议不是面向连接的协议。使用UDP协议时，只要知道服务器的IP和端口，就可以直接向对方发送数据。

使用流程

1. 获取Channel
   ```java
         //获得一个套接字传输通道
         DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);
      ```

2. 读取DatagramChannel数据报通道数据
    ```java
    //创建缓冲区
    ByteBufferbuf = ByteBuffer.allocate(1024);
    //从DatagramChannel读入，再写入到ByteBuffer缓冲区
    SocketAddressclientAddr= datagramChannel.receive(buffer);
    ```
3. 写入通道
    ```java
    //把缓冲区翻转到读取模式
    buffer.flip();
    //调用send方法，把数据发送到目标IP+端口
    dChannel.send(buffer, new InetSocketAddress(NioDemoConfig.SOCKET_SERVER_IP,
    NioDemoConfig.SOCKET_SERVER_PORT));
    //清空缓冲区，切换到写入模式
    buffer.clear();
    ```
4. 关闭通道
    ```java
       dChannel.close();
    ```
## NIO Selector选择器  
选择器的使命是完成IO的多路复用。一个通道代表一条连接通路，
通过选择器可以同时监控多个通道的IO（输入输出）状况。选择器和通道的关系，
是监控和被监控的关系。 

通道和选择器之间的关系，通过register（注册）的方式完成。调用通道的
Channel.register（Selector sel，int ops）方法，可以将通道实例注册到一个选择器
中。register方法有两个参数：第一个参数，指定通道注册到的选择器实例；第二个
参数，指定选择器要监控的IO事件类型。

可供选择器监控的通道IO事件类型，包括以下四种：
* 可读：SelectionKey.OP_READ
* 可写：SelectionKey.OP_WRITE
* 连接：SelectionKey.OP_CONNECT
* 接收：SelectionKey.OP_ACCEPT

事件类型的定义在SelectionKey类中。如果选择器要监控通道的多种事件，可以
用“按位或”运算符来实现。例如，同时监控可读和可写IO事件：
```java
//监控通道的多种事件，用“按位或”运算符来实现
int key = SelectionKey.OP_READ | SelectionKey.OP_WRITE ;
```

什么是IO事件呢？这个概念容易混淆，这里特别说明一下。这里的IO事件不是
对通道的IO操作，而是通道的某个IO操作的一种就绪状态，表示通道具备完成某个
IO操作的条件。

* 某个SocketChannel通道，完成了和对端的握手连接，则处于“连接就
绪”（OP_CONNECT）状态。

* 再比方说，某个ServerSocketChannel服务器通道，监听到一个新连接的到来，
则处于“接收就绪”（OP_ACCEPT）状态。

* 还比方说，一个有数据可读的SocketChannel通道，处于“读就绪”（OP_READ）
状态；一个等待写入数据的，处于“写就绪”（OP_WRITE）状态。

**不是所有通道都可以监听的，只有继承了SelectableChannel 才可以监听**

选择器使用流程
1. 获取选择器实例；
```java
/调用静态工厂方法open()来获取Selector实例
Selector selector = Selector.open();
```
1. 将通道注册到选择器中；
```java
// 2.获取通道
ServerSocketChannelserverSocketChannel = ServerSocketChannel.open();
// 3.设置为非阻塞
serverSocketChannel.configureBlocking(false);
// 4.绑定连接
serverSocketChannel.bind(new InetSocketAddress(SystemConfig.SOCKET_SERVER_PORT));
// 5.将通道注册到选择器上,并制定监听事件为：“接收连接”事件
serverSocketChannel.register(selector，SelectionKey.OP_ACCEPT);
```
1. 轮询感兴趣的IO就绪事件（选择键集合）。
```java
//轮询，选择感兴趣的IO就绪事件（选择键集合）
while (selector.select() > 0) {
    Set selectedKeys = selector.selectedKeys();
    Iterator keyIterator = selectedKeys.iterator();
    while(keyIterator.hasNext()) {
        SelectionKey key = keyIterator.next();
        //根据具体的IO事件类型，执行对应的业务操作
        if(key.isAcceptable()) {
        // IO事件：ServerSocketChannel服务器监听通道有新连接
        } else if (key.isConnectable()) {
        // IO事件：传输通道连接成功
        } else if (key.isReadable()) {
        // IO事件：传输通道可读
        } else if (key.isWritable()) {
        // IO事件：传输通道可写
        }
        //处理完成后，移除选择键
        keyIterator.remove();
    }
}
```
