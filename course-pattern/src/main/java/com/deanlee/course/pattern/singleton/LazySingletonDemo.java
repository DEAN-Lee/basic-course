package com.deanlee.course.pattern.singleton;



/*
 意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点。

 主要解决：一个全局使用的类频繁地创建与销毁。

 何时使用：当您想控制实例数目，节省系统资源的时候。

 如何解决：判断系统是否已经有这个单例，如果有则返回，如果没有则创建。

 关键代码：构造函数是私有的。
 懒汉模式：
 初始化数据
 线程非安全
 */

public class LazySingletonDemo {
    private static LazySingletonDemo lazySingletonDemo;

    private LazySingletonDemo() {
        System.out.println("SingletonDemo");
    }

    public static LazySingletonDemo getLazySingletonDemo() {
        if (lazySingletonDemo == null) {
            lazySingletonDemo = new LazySingletonDemo();
        }
        return lazySingletonDemo;
    }


    public static void main(String[] args) {
        LazySingletonDemo lazySingletonDemo = LazySingletonDemo.getLazySingletonDemo();
        LazySingletonDemo lazySingletonDemo1 = LazySingletonDemo.getLazySingletonDemo();
        System.out.println(lazySingletonDemo == lazySingletonDemo1);
    }


}
