package com.test;

import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {
        SharedSpace sharedSpace = new SharedSpace(new LinkedBlockingQueue<Integer>(10));
        new Thread(new Producer(sharedSpace)).start();


        Consumer consumerRunnable = new Consumer(sharedSpace);
        new Thread(consumerRunnable).start();
        new Thread(consumerRunnable).start();
        new Thread(consumerRunnable).start();
    }
}
