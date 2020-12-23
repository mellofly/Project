package com.it.thread;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args){
        /*
        * 三种原始方法都调用的ThreadPoolExecutor方法。
        * 存在问题：2，3方法中队列使用的是LinkedBlockingQUeue，这是一个无限长的队列，当任务过多时，占用内存过高，会造成内存溢出。
        * 1方法中非核心线程是没有限定的，当任务太多时，会创建过多的线程，占用CPU过多。
        * 自定义方法存在问题：当任务量太多时，会触发拒绝策略。
        *
        * 线程池的提交顺序：核心线程-队列-非核心线程
        * 线程池的提交顺序：核心线程-非核心线程-队列
        * */
        //按照需要创建新线程的线程池：核心线程为0，序列为SynchronousQueue。
        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建指定数量线程的线程池：全部创建核心线程。序列为LinkedBlockingQueue。
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        //创建使用单个线程的线程池：全部创建核心线程池。序列为LinkedBlockingQueue。
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        //使用自定义的线程池：其实就是调用原始方法底层调用的方法。
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,20,0l, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10));
        for(int i=1;i<100;i++){
            executorService2.submit(new MyTask(i));
        }
    }
}
