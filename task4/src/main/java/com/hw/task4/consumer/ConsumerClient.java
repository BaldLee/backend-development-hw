package com.hw.task4.consumer;

import java.io.*;
import java.net.Socket;

public class ConsumerClient {
    public ConsumerClient() {
    }

    public void getProduct() {
        try {
            Socket socket = new Socket("127.0.0.1", 55555);
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);

            //向服务器端发送一条消息
            pw.write("c@0\n");
            pw.flush();

            //读取服务器端的消息
            String mess = br.readLine();
            System.out.println("consumer gets product: " + mess);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
