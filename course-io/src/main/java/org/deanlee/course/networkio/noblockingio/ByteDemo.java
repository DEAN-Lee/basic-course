package org.deanlee.course.networkio.noblockingio;
import com.google.common.collect.Maps;

import com.alibaba.fastjson.JSON;
import com.lcb.soa.misc.common.util.MD5Util;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.util.*;

/**
 * @author LiMeng
 * @version 1.0
 * @date 2019-11-21 20:57
 * 同步非阻塞-多路复用实现
 */
public class ByteDemo {
    /**
     * 二进制 测试
     */
    public static void byteBufferTest() {
        //初始
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        //赋值
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 2);
        byteBuffer.put((byte) 3);
        byteBuffer.put((byte) 4);
        byteBuffer.put((byte) 5);
        byteBuffer.put((byte) 6);
        byteBuffer.put((byte) 7);
        byteBuffer.put((byte) 8);
        byteBuffer.put((byte) 9);
        byteBuffer.put((byte) 10);
        byteBuffer.put((byte) 11);
        byteBuffer.put((byte) 12);
        byteBuffer.put((byte) 13);
        byteBuffer.put((byte) 14);
        //打印参数值
        System.out.println("put ------>limit " + byteBuffer.limit());
        System.out.println("put ------>position" + byteBuffer.position());
        System.out.println("put ------>capacity" + byteBuffer.capacity());
        //切换模式读模式
        byteBuffer.flip();
        //输出参数值
        System.out.println("flip after------>limit" + byteBuffer.limit());
        System.out.println("flip after------>position" + byteBuffer.position());
        System.out.println("flip after------>capacity" + byteBuffer.capacity());
        //输出2buffer数量
        for (int i = 0; i < 2; i++) {
            System.out.println(byteBuffer.get());
        }

        //输出3buffer数量 后 参数值
        System.out.println("print two element after------>limit" + byteBuffer.limit());
        System.out.println("print two element after------>position" + byteBuffer.position());
        System.out.println("print two element after------>capacity" + byteBuffer.capacity());
        //输出内容
        for (int i = 0; i < 4; i++) {
            System.out.println(byteBuffer.get());
        }
        // 输出4buffer数量 后 参数值
        System.out.println("print four element after------>limit" + byteBuffer.limit());
        System.out.println("print four element after------>position" + byteBuffer.position());
        System.out.println("print four element after------>capacity" + byteBuffer.capacity());

        //切换为写模式 or Buffer.compact()
        byteBuffer.clear();

        // 切换写模式后数值
        System.out.println("clear after------>limit" + byteBuffer.limit());
        System.out.println("clear after------>position" + byteBuffer.position());
        System.out.println("clear after------>capacity" + byteBuffer.capacity());

        System.out.println("OP_ACCEPT------>" + SelectionKey.OP_ACCEPT);
        System.out.println("OP_READ------>" + SelectionKey.OP_READ);
        System.out.println("OP_WRITE------>" + SelectionKey.OP_WRITE);
        System.out.println("OP_CONNECT------>" + SelectionKey.OP_CONNECT);



    }

    public static void main(String[] args) {
//        byteBufferTest();
        Long timespan = System.currentTimeMillis();
        System.out.println(timespan);
        String key = "F26DC4ACB5385711D0686507238703A4";
        String sign = MD5Util.getMD5(timespan.toString().concat("{}").concat(key));
        System.out.println(sign.toUpperCase());
        OrderExtOpenNotifyRequest t = new OrderExtOpenNotifyRequest();
        t.setOuterOrderId("1");
        t.setOrderNumber("2");
        t.setPayAmount(0);
        t.setNotifyType("");
        t.setUpdateStatus(0);
        t.setTimestamp(0L);

        Map temp = new HashMap<>();
        temp.put("11", "111");
        temp.put("1111", "34");
        t.setExtInfo(temp);
        System.out.println(JSON.toJSONString(t));

        System.out.println(1 << 30);

    }

    public static void excel(Integer temp){
        System.out.println("temp = " +  (temp > 300000 ? temp - (temp / 300000) * 300000 : temp));
    }
}
