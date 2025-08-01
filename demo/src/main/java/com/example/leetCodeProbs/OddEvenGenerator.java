package com.example.leetCodeProbs;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class OddEvenGenerator implements Runnable {

    final Object object;
    static int count = 1;
    int rem;

    public OddEvenGenerator(Object object, int remainder) {
        this.object = object;
        this.rem = remainder;
    }


    public static void main(String[] args) {
        Object lockObj = new Object();
        Runnable run1 = new OddEvenGenerator(lockObj, 1);
        Runnable run2 = new OddEvenGenerator(lockObj, 0);
        Thread thread1 = new Thread(run1, "Thread 1: ");
        Thread thread2 = new Thread(run2, "Thread 2: ");

        thread1.start();
        thread2.start();


    }

    @Override
    public void run() {

        synchronized (object) {
            while (count <= 10) {
                if (count % 2 != rem) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Thread Name: " + Thread.currentThread().getName() + ":" + count);
                count++;
                object.notifyAll();
            }

        }
    }
}
