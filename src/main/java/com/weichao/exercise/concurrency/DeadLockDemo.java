package com.weichao.exercise.concurrency;

/**
 * 线程死锁例子
 */
public class DeadLockDemo{

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    try {
                        Thread.sleep(3000);
                        System.out.println("Thread1获取到lock1");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2){
                        System.out.println("Thread1获取到lock2");
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2){
                    try {
                        Thread.sleep(3000);
                        System.out.println("Thread2获取到lock2");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1){
                        System.out.println("Thread2获取到lock1");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }

}










