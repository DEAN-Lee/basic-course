package org.deanlee.course.thread;

import com.google.common.util.concurrent.*;

import java.util.concurrent.*;

/**
 * guava 扩展
 */
public class GuavaFutureDemo {
    public static String getCurThreadName() {
        return Thread.currentThread().getName();
    }

    static class AThread implements Callable<Boolean> {
        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public Boolean call() throws Exception {
            System.out.println(Thread.currentThread().getName() + "AThread start");
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName() + "BThread end");
            return true;
        }
    }

    static class BThread implements Callable<Boolean>{
        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public Boolean call() throws Exception {
            System.out.println(Thread.currentThread().getName() + "BThread start");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "BThread end");
            return true;
        }
    }

    //泡茶线程
    static class MainJob implements Runnable {

        boolean aOk = false;
        boolean bOk = false;
        int gap = 1000 / 10;

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(gap);
                    System.out.println("主线程执行中......");
                } catch (InterruptedException e) {
                    System.out.println(getCurThreadName() + "发生异常被中断.");
                }

                if (aOk && bOk) {
                    successTest(aOk, bOk);
                }
            }
        }


        public void successTest(Boolean aOk, Boolean bOK) {
            if (aOk && bOK) {
                System.out.println("成功");
                this.aOk = false;
                this.gap = 1000 * 100;
            } else if (!aOk) {
                System.out.println("A失败，没有茶喝了");
            } else if (!bOK) {
                System.out.println("杯子洗不了，没有茶喝了");
            }

        }
    }

    public static void main(String[] args) {
        long times = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "main start " + times);

        //新起一个线程，作为泡茶主线程
        MainJob mainJob = new MainJob();
        Thread mainThread = new Thread(mainJob);
        mainThread.setName("主线程");
        mainThread.start();

        AThread aThread = new AThread();
        BThread bThread = new BThread();

        //创建java 线程池
        ExecutorService jPool =
                Executors.newFixedThreadPool(10);

        //包装java线程池，构造guava 线程池
        ListeningExecutorService gPool =
                MoreExecutors.listeningDecorator(jPool);

        //提交A的业务逻辑，取到异步任务
        ListenableFuture<Boolean> aFuture = gPool.submit(aThread);
        //绑定任务执行完成后的回调，到异步任务
        Futures.addCallback(aFuture, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean r) {
                if (r) {
                    mainJob.aOk = true;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("A失败");
            }
        });
        //提交清洗的业务逻辑，取到异步任务

        ListenableFuture<Boolean> washFuture = gPool.submit(bThread);
        //绑定任务执行完成后的回调，到异步任务
        Futures.addCallback(washFuture, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean r) {
                if (r) {
                    mainJob.bOk = true;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("B失败");
            }
        });


    }
}
