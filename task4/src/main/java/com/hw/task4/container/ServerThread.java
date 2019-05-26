package com.hw.task4.container;

import com.hw.task4.Entity.Product;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    Socket socket = null;
    Container container = null;

    public ServerThread(Socket socket, Container container) {
        this.socket = socket;
        this.container = container;
    }

    @Override
    public void run() {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String read = null;
            read = br.readLine();
            socket.shutdownInput();

            String[] info = read.split("@");
            if (info[0].equals("p")) {
                Product product = new Product(Integer.parseInt(info[1]));
                container.push(product);
                os = socket.getOutputStream();
                pw = new PrintWriter(os);
                pw.write("server gets product\n");
                pw.flush();
            }
            if (info[0].equals("c")) {
                Product product = container.pop();
                os = socket.getOutputStream();
                pw = new PrintWriter(os);
                if (product != null) {
                    pw.write(product.getContent() + "\n");
                    pw.flush();
                } else {
                    pw.write("null\n");
                    pw.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw != null) pw.close();
                if (os != null) os.close();
                if (br != null) br.close();
                if (isr != null) isr.close();
                if (is != null) is.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
