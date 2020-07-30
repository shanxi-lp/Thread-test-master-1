package com.interview.threadPool;

import java.util.ArrayList;

/**
 * 局部变量
 */
public class ThreadTest1_4 {
    static final int THREAD_NUMBER=2;
    static final int LOOP_NUMBER=200;
    public static void main(String[] args) {
        ThreadSafe threadUnSafe=new ThreadSafe();
        for (int i = 0; i <THREAD_NUMBER ; i++) {
            new Thread(()->{
                threadUnSafe.method1(LOOP_NUMBER);
            },"Thread"+(i+1)).start();
        }
    }
}
class ThreadSafe{
    public void method1(int loopnumber){
        for (int i = 0; i <loopnumber ; i++) {
    ArrayList<String> arrayList=new ArrayList<>();
            method2(arrayList);
            method3(arrayList);
        }
    }
    private void method2(ArrayList arrayList){
        arrayList.add("1");
    }
    private void method3(ArrayList arrayList){
        arrayList.remove(0);
    }
}
