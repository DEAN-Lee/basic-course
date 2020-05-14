package com.deanlee.course.pattern.singleton;

/**
 * 双锁校验
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：较复杂
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 *  synchronized
 *  volatile
 */
public class DCLSingletonDemo {
    // volatile 修饰
    private volatile static DCLSingletonDemo instance;
    // 私有构造函数
    private DCLSingletonDemo(){

    }


    public static DCLSingletonDemo getInstance(){
        if (instance == null) {
            synchronized (DCLSingletonDemo.class){ //同步锁
                if (instance==null){
                    instance = new DCLSingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
//       singletonThread();
        multiThread();
    }

    public static void singletonThread() {
        DCLSingletonDemo instance = DCLSingletonDemo.getInstance();
        DCLSingletonDemo instance1 = DCLSingletonDemo.getInstance();
        System.out.println("instance1:" + instance1.hashCode());
        System.out.println("instance:" + instance.hashCode());
        System.out.println(instance == instance1);
    }

    public static void multiThread() {
        Runnable task = () -> {
            DCLSingletonDemo instance = DCLSingletonDemo.getInstance();
            System.out.println("lazySingletonDemo:" + instance.hashCode());
        };

        for (int i = 0; i < 4; i++) {
            new Thread(task, "" + i).start();
        }
    }
}
