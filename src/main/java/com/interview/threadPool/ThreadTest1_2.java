package com.interview.threadPool;

/**
 * 锁对象面向对象
 *
 * 锁加在this代表对象
 * 锁加在static方法上代表类对象
 */

import org.apache.log4j.Logger;

public class ThreadTest1_2 {
    private static Logger logger= Logger.getLogger(ThreadTest1_2.class);
    public static void main(String[] args) throws Exception{
        Room room=new Room();
        Thread t1=new Thread(()->{
            for (int i = 0; i <5000 ; i++) {
                room.add();
            }
        },"t1");
        Thread t2=new Thread(()->{
            for (int i = 0; i <5000 ; i++) {
                room.reduce();
            }
        },"t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        logger.info(room.getCount());
    }
}
class Room{
    private int count=0;
    public void add(){
        synchronized (this){
            count++;
        }
    }
    public void reduce(){
        synchronized (this){
            count--;
        }
    }
    public int getCount(){
        synchronized (this){
            return count;
        }
    }
}

