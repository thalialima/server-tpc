package br.com.thread.server;

import java.net.ServerSocket;

public class DistributeTasks implements Runnable {
    private ServerSocket serverSocket;
    public DistributeTasks(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
