package com.hw.task4.Demo;

import com.hw.task4.producer.ProducerClient;

public class ProThread extends Thread {
    public void ProThread() {
    }

    @Override
    public void run() {
        ProducerClient producerClient = new ProducerClient();
        while (true) {
            producerClient.sendProduct();
            //delay 100ms
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
