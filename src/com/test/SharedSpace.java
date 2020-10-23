package com.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class SharedSpace {
    private BlockingQueue<Integer> queue;

    public SharedSpace(BlockingQueue<Integer> queue) {
        super();
        this.queue = queue;
    }

    public BlockingQueue<Integer> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void addValue(int value)
    {
        try {
            queue.put(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Integer getValue() throws InterruptedException
    {
        return queue.poll(10, TimeUnit.SECONDS);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
