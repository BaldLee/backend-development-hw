package com.hw.task4.Demo;

import com.hw.task4.producer.ProducerClient;

public class Main {
    public static void main(String[] args) {
        //运行服务端
        ContainerThread containerThread = new ContainerThread();
        containerThread.start();

        //先生产30个
        ProducerClient producerClient = new ProducerClient();
        for (int i = 0; i < 30; i++) {
            producerClient.sendProduct();
        }

        //运行消费者和生产者
        ProThread proThread = new ProThread();
        ConThread conThread = new ConThread();
        proThread.start();
        conThread.start();

        //运行3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        return;
    }
}
