package com.test;

public class Producer implements Runnable {
    private SharedSpace sharedSpace;

    public Producer(SharedSpace sharedSpace) {
        super();
        this.sharedSpace = sharedSpace;
    }

    public SharedSpace getSharedSpace() {
        return sharedSpace;
    }

    public void setSharedSpace(SharedSpace sharedSpace) {
        this.sharedSpace = sharedSpace;
    }

    @Override
    public void run() {
        for(int i=0;i<100_000;i++)
        {
            sharedSpace.addValue(i);
            System.out.println("Producer added value " + i);
        }
    }
}
