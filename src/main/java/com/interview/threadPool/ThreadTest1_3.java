package com.interview.threadPool;

import java.util.ArrayList;

/**
 * 成员变量不安全
 */
public class ThreadTest1_3 {
        static final int THREAD_NUMBER=2;
        static final int LOOP_NUMBER=200;
    public static void main(String[] args) {
        ThreadUnSafe threadUnSafe=new ThreadUnSafe();
        for (int i = 0; i <THREAD_NUMBER ; i++) {
                new Thread(()->{
                    threadUnSafe.method1(LOOP_NUMBER);
                },"Thread"+(i+1)).start();
        }
    }
}
class ThreadUnSafe{
    ArrayList<String> arrayList=new ArrayList<>();
    public void method1(int loopnumber){
        for (int i = 0; i <loopnumber ; i++) {
            method2();
            method3();
        }
    }
    private void method2(){
        arrayList.add("1");
    }
    private void method3(){
        arrayList.remove(0);
    }
}