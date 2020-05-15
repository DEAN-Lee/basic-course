package com.deanlee.course.pattern.singleton;

/**
 * 静态内部类实现
 *
 * 是否 Lazy 初始化：是
 *
 * 是否多线程安全：是
 *
 * 实现难度：一般
 *
 * 描述：这种方式能达到双检锁方式一样的功效，但实现更简单。对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。
 * 这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
 * 推荐使用：明确实现 lazy loading 效果时，使用
 */
public class StaticSingletonDemo {
    //静态内部类
    private static class StaticSingletonDemoInner{
        private static final StaticSingletonDemo INSTANCE = new StaticSingletonDemo();
    }
    //私有构造函数
    private StaticSingletonDemo(){}

    public static StaticSingletonDemo getInstance(){
       return StaticSingletonDemoInner.INSTANCE;
    }

    public static void main(String[] args) {
//       singletonThread();
        multiThread();
    }

    public static void singletonThread() {
        StaticSingletonDemo instance = StaticSingletonDemo.getInstance();
        StaticSingletonDemo instance1 = StaticSingletonDemo.getInstance();
        System.out.println("instance1:" + instance1.hashCode());
        System.out.println("instance:" + instance.hashCode());
        System.out.println(instance == instance1);
    }

    public static void multiThread() {
        Runnable task = () -> {
            StaticSingletonDemo instance = StaticSingletonDemo.getInstance();
            System.out.println("StaticSingletonDemo:" + instance.hashCode());
        };

        for (int i = 0; i < 4; i++) {
            new Thread(task, "" + i).start();
        }
    }
}
