package org.deanlee.course.tcp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TCP/IP
 * TCP 报文20字节
 * client 逐层添加协议报文  service 逐层解析协议报文
 *
 * http
 *
 * http TCP
 *
 * http tcp IP
 *
 * http tcp ip 链路层报文
 *
 * 三次握手
 * C---SYN: seq=j  ----------------->S
 * s---SYN ACK : seq=k ack=j+1 ----->c
 * C---ACK : seq=j+1 ack=k+1 ------->S
 *
 * 数据传输
 * c-----PUH ACK: seq=j+1 ack=K+1 len=x--------->s
 * S-----PUH ACK: seq=k+1 ack=j+1+x len=y------->c
 *
 * C-----ACK: seq=j+1+x+1 ack=k+1+y------------->S
 *
 * 四次挥手
 * C-----FIN ACK: seq=j+1+x+1 ack=k+1+y-------->S    C-->FIN_WAIT_1
 * S-----ACK: seq=k+1+y ack=j+1+x+1+1---------->C    C-->FIN_WAIT_2   S-->CLOSE-WAIT
 * S-----FIN ACK: seq=K+1+y ack=j+1+x+1+1------>C    C-->FIN_WAIT_2   s-->LAST-ACK
 * C-----ACK: seq=j+1+x+1+1 ack=K+1+y+1-------->S    c-->TIME_WAIT    c-->CLOSED
 *
 * 挥手最后client 等待一段时间2MSL 最长报文段寿命 然后再关闭对话。
 *
 * 三次握手/四次挥手 ack=seq+1
 * 数据传输是 ack=seq+len  len传输数据长度
 *
 * 使用Wireshark 抓包处理
 * docs文档中有抓好的包，可以做错参考
 * 过滤条件：tcp.stream eq 496
 */
@RestController
public class HelloController {
    private static final String template = "Hello, %s!";

    @GetMapping("/getWord")
    public String getWord(@RequestParam(value = "name", defaultValue = "word") String name) {
        return String.format(template, name);
    }
}
