package com.interview.threadPool;

import org.apache.log4j.Logger;

/**
 * 线程不安全实例
 */
public class ThreadTest1 {
    private static Logger logger=Logger.getLogger(ThreadTest1.class);
 static  int count=0;
    public static void main(String[] args)throws Exception {
        Thread t1=new Thread(()->{
            for (int i = 0; i <5000 ; i++) {
                count++;
            }
        },"t1");
        Thread t2=new Thread(()->{
            for (int i = 0; i <5000 ; i++) {
                count--;
            }
        },"t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        logger.info(count);
    }
}
