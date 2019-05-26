package com.hw.task4.Demo;

import com.hw.task4.producer.ProducerClient;

public class Main {
    public static void main(String[] args) {
        //运行服务端
        ContainerThread containerThread = new ContainerThread();
        containerThread.start();

        //先生产60个
        ProducerClient producerClient = new ProducerClient();
        for (int i = 1; i < 61; i++) {
            producerClient.sendProduct(i);
        }

        //运行消费者和生产者
        ProThread proThread = new ProThread();
        ConThread conThread = new ConThread();
        proThread.start();
        conThread.start();
    }
}
