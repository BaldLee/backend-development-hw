package com.hw.task4.container;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server() {
    }

    public void runServer() {
        try {
            System.out.println("starting server... ");
            ServerSocket serverSocket = new ServerSocket(55555);
            Socket socket = null;
            Container container = new Container();
            while (true) {
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket, container);
                serverThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
