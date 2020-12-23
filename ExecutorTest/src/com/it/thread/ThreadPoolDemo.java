package com.it.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        for(int i=1;i<100;i++){
            executorService1.submit(new MyTask(i));
        }
    }
}
