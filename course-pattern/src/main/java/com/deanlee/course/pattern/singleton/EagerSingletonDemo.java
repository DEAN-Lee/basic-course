package com.deanlee.course.pattern.singleton;


/**
 * 意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * 主要解决：一个全局使用的类频繁地创建与销毁。
 * 何时使用：当您想控制实例数目，节省系统资源的时候。
 * 如何解决：判断系统是否已经有这个单例，如果有则返回，如果没有则创建。
 * 关键代码：构造函数是私有的。
 * 饿汉模式：
 * 初始化数据:是
 * 在类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快
 * 它基于 classloader 机制避免了多线程的同步问题.
 * 初始化数据过多
 */
public class EagerSingletonDemo {
    private static EagerSingletonDemo instance = new EagerSingletonDemo();

    private EagerSingletonDemo() {
        System.out.println("EagerSingletonDemo init");
    }

    public static EagerSingletonDemo getInstance() {
        return instance;
    }


    public static void main(String[] args) {
//       singletonThread();
        multiThread();
    }

    public static void singletonThread() {
        EagerSingletonDemo instance = EagerSingletonDemo.getInstance();
        EagerSingletonDemo instance1 = EagerSingletonDemo.getInstance();
        System.out.println("instance1:" + instance1.hashCode());
        System.out.println("instance:" + instance.hashCode());
        System.out.println(instance == instance1);
    }

    public static void multiThread() {
        Runnable task = () -> {
            EagerSingletonDemo instance = EagerSingletonDemo.getInstance();
            System.out.println("EagerSingletonDemo:" + instance.hashCode());
        };

        for (int i = 0; i < 4; i++) {
            new Thread(task, "" + i).start();
        }
    }


}
