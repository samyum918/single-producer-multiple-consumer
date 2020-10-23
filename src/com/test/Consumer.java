package com.test;

public class Consumer implements Runnable {
    private SharedSpace sharedSpace;
    private int cnt = 0;

    public Consumer(SharedSpace sharedSpace) {
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
    public void run()
    {
        try {
            while (true) {
                Integer valueConsumed = sharedSpace.getValue();
                if(valueConsumed != null) {
                    System.out.println(Thread.currentThread().getName() + " get the value: " + valueConsumed + ", Count: " + ++cnt);
                }
                else {
                    System.out.println(Thread.currentThread().getName() + ", Last count: " + cnt);
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
