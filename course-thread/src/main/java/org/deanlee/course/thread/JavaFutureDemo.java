package org.deanlee.course.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * future task demo
 * @author dean_lee
 */
public class JavaFutureDemo {
    static class AThread implements Callable<Boolean>{

        @Override
        public Boolean call() throws Exception {
            System.out.println(Thread.currentThread().getName() + "AThread start");
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName() + "BThread end");
            return true;
        }
    }

    static class BThread implements Callable<Boolean>{

        @Override
        public Boolean call() throws Exception {
            System.out.println(Thread.currentThread().getName() + "BThread start");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "BThread end");
            return true;
        }
    }

    public static void main(String[] args) {
        long times = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "main start " + times);

        FutureTask<Boolean> aTask = new FutureTask(new AThread());
        Thread aThread = new Thread(aTask, "** A-Thread");

        FutureTask<Boolean> bTask = new FutureTask(new BThread());
        Thread bThread = new Thread(bTask, "** b-Thread");
        aThread.start();
        bThread.start();

        try {
            boolean  warterOk = aTask.get();
            boolean  cupOk = bTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "main done "+ ((System.currentTimeMillis()-times)/1000));


    }
}
