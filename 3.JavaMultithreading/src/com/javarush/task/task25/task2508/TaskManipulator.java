package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread current;

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName());
            try {
                current.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    @Override
    public void start(String threadName) {

        Thread newThread = new Thread(this, threadName);
        current = newThread;

        newThread.start();
    }

    @Override
    public void stop() {
        current.interrupt();
    }
}
