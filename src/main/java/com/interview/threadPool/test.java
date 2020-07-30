package com.interview.threadPool;

import java.util.concurrent.*;

public class test {
    public static void main(String[] args) {

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();//创建一个可缓存线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);//创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);//创建一个定长线程池，支持定时及周期性任务执行
        ExecutorService single = Executors.newSingleThreadExecutor();//创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
        for(int i=0;i<10;i++){
            final int index = i;
            try {
                Thread.sleep(index*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });

            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
            //定期3s执行
            scheduledExecutorService.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("delay 3s");
                }
            }, 3, TimeUnit.SECONDS);

            single.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }
}

