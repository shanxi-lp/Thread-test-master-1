package com.interview.threadPool;

import org.apache.log4j.Logger;

/**
 * synchronized的使用
 * 锁对象
 */
public class ThreadTest1_1 {
    private static Logger logger=Logger.getLogger(ThreadTest1_1.class);
    static int count=0;
    static Object lock=new Object();
    public static void main(String[] args) throws Exception {
            Thread t1=new Thread(()->{
                for (int i = 0; i <5000 ; i++) {
                    synchronized (lock){
                        count++;
                    }
                }
            },"t1");
            Thread t2=new Thread(()->{
                for (int i = 0; i <5000 ; i++) {
                    synchronized (lock){
                        count--;
                    }
                }
            },"t2");
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            logger.info(count);
    }
}
