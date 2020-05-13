package com.deanlee.course.pattern.singleton;



/*
 意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点。

 主要解决：一个全局使用的类频繁地创建与销毁。

 何时使用：当您想控制实例数目，节省系统资源的时候。

 如何解决：判断系统是否已经有这个单例，如果有则返回，如果没有则创建。

 关键代码：构造函数是私有的。
 懒汉模式：
 初始化数据:否
 线程安全 排它锁性能问题
 不建议使用
 */

public class LazySingletonUpgradeDemo {
    private static LazySingletonUpgradeDemo instance;

    private LazySingletonUpgradeDemo() {
        System.out.println("LazySingletonUpgradeDemo init");
    }

    public static synchronized LazySingletonUpgradeDemo getInstance() {
        if (instance == null) {
            instance = new LazySingletonUpgradeDemo();
        }
        return instance;
    }


    public static void main(String[] args) {
//       singletonThread();
       multiThread();
    }

    public static void singletonThread() {
        LazySingletonUpgradeDemo instance = LazySingletonUpgradeDemo.getInstance();
        LazySingletonUpgradeDemo instance1 = LazySingletonUpgradeDemo.getInstance();
        System.out.println("instance1:" + instance1.hashCode());
        System.out.println("instance:" + instance.hashCode());
        System.out.println(instance == instance1);
    }

    public static void multiThread() {
        Runnable task = () -> {
            LazySingletonUpgradeDemo instance = LazySingletonUpgradeDemo.getInstance();
            System.out.println("lazySingletonDemo:" + instance.hashCode());
        };

        for (int i = 0; i < 4; i++) {
            new Thread(task,""+i).start();
        }
    }


}
