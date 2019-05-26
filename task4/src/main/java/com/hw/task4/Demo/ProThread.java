package com.hw.task4.Demo;

import com.hw.task4.producer.ProducerClient;

public class ProThread extends Thread {
    public void ProThread() {
    }

    @Override
    public void run() {
        ProducerClient producerClient = new ProducerClient();
        for (int i = 61; i < 300; i++) {
            producerClient.sendProduct(i);
            //delay 120ms
            try {
                Thread.sleep(120);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
