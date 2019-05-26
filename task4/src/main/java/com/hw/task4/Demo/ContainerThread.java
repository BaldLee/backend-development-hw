package com.hw.task4.Demo;

import com.hw.task4.container.Server;

public class ContainerThread extends Thread {
    public ContainerThread() {
    }

    @Override
    public void run() {
        Server server = new Server();
        server.runServer();
    }
}
