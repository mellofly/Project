package com.it.thread;

public class MyTask implements  Runnable{
    protected  int index;
    public MyTask(int i){
        this.index=i;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"---"+index);
        try{
            Thread.sleep(1000l);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
