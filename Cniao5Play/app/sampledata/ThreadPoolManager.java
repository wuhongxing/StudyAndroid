package com.example.cniao5play;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager {
    private LinkedBlockingDeque<Runnable> mQueue = new LinkedBlockingDeque<>();

    private static ThreadPoolManager threadPoolManager = new ThreadPoolManager();
    public static ThreadPoolManager getInstance() {
        return  threadPoolManager;
    }

    private ThreadPoolExecutor mThreadPoolExecutor;
    private ThreadPoolManager() {
        mThreadPoolExecutor = new ThreadPoolExecutor(3, 10, 15, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                        addTask(runnable);
                    }
                });
    }

    public void addTask(Runnable runnable) {
        try {
            mQueue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Runnable coreThread = new Runnable() {
        Runnable runn = null;
        @Override
        public void run() {
            while (true) {
                try {
                    runn = mQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mThreadPoolExecutor.execute(runn);
            }
        }
    };
}
