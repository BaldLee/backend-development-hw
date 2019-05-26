package com.hw.task4.producer;

import com.hw.task4.Entity.Product;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class ProducerClient {
    public ProducerClient() {
    }

    public void sendProduct() {
        try {
            Socket socket = new Socket("127.0.0.1", 55555);
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);

            //向服务器端发送一条消息
            Random random = new Random(System.currentTimeMillis());
            int a = random.nextInt();
            System.out.println("send: " + a);
            pw.write("p@" + a + "\n");
            pw.flush();

            //读取服务器端的消息
            String mess = br.readLine();
            System.out.println("producer sends product: " + mess);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
