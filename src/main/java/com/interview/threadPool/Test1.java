package com.interview.threadPool;

public class Test1 {
    public static void main(String[] args) {
            Son father=new Son();
            father.aa();
    }
}
class Father{
    public void result(){
        System.out.println("爸爸来了");
    }
    public void aa(){

        result();
    }
}
class Son extends Father{
    @Override
    public void result() {

        System.out.println("儿子来了");
    }
}
