package com.example.leetCodeProbs;

public class SequenceGeneratorMultithread {
    private static final Object lock = new Object();
    private static int currentValue = 1;
    private static int numberOfThreads = 3;
    private static int maxSequence = 10;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> sequenceGenerate(1), "thread-1");
        Thread t2 = new Thread(() -> sequenceGenerate(2), "thread-2");
        Thread t3 = new Thread(() -> sequenceGenerate(0), "thread-3");

        t1.start();
        t2.start();
        t3.start();
    }

    public static void sequenceGenerate(int result){


        synchronized (lock){
            while(currentValue <= maxSequence){
                if (currentValue % numberOfThreads != result) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println("Thread "+ Thread.currentThread().getName() + "currentValue "+ currentValue);
                    currentValue++;
                    lock.notifyAll();
                }
            }
        }
    }
}
