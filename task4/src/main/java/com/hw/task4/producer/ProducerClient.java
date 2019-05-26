package com.hw.task4.producer;

import com.hw.task4.Entity.Product;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class ProducerClient {
    public ProducerClient() {
    }

    public void sendProduct(int i) {
        try {
            Socket socket = new Socket("127.0.0.1", 55555);
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);

            //向服务器端发送一个随机数
            Random random = new Random(System.currentTimeMillis());
            pw.write("p@" + random.nextInt() + "\n");
            pw.flush();

            //读取服务器端的消息
            String mess = br.readLine();
            System.out.println("[PRODUCER " + i + "]\tproducer sends product: " + mess);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
