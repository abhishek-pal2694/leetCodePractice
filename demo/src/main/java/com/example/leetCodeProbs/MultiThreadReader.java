package com.example.leetCodeProbs;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadReader {

    public static void main(String[] args) {
        ExecutorService oddexecutor = Executors.newFixedThreadPool(1);
        ExecutorService evenexecutor = Executors.newFixedThreadPool(1);

        Object obj = new Object();
        oddexecutor.submit(new OddEvenGenerator(obj,1));
        evenexecutor.submit(new OddEvenGenerator(obj,0));
        evenexecutor.shutdown();
        oddexecutor.shutdown();
    }
}
