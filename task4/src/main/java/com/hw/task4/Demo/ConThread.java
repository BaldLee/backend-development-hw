package com.hw.task4.Demo;


import com.hw.task4.consumer.ConsumerClient;

public class ConThread extends Thread {
    public ConThread() {
    }

    @Override
    public void run() {
        ConsumerClient consumerClient = new ConsumerClient();
        for (int i = 0; i < 300; i++) {
            consumerClient.getProduct(i);
            //delay 100ms
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
