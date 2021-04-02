package org.deanlee.course.thread;

/**
 * join 基础操作
 *
 * @author limeng
 */
public class JoinThreadDemo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "main start");
        AThread aThread = new AThread();
        BThread bThread = new BThread();
        aThread.start();
        bThread.start();
        try {

            aThread.join();
            bThread.join();
            System.out.println(Thread.currentThread().getName() + "main done");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static class AThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "AThread start");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "AThread end");
        }
    }

    static class BThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "BThread  start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "BThread end");
        }
    }


}
