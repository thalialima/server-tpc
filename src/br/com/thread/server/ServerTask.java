package br.com.thread.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTask {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1212);
        while (true) {
            Socket accept = serverSocket.accept();
            System.out.println("Aceitando conexão na porta " + accept.getPort());
            Thread clientThread = new Thread(new DistributeTasks(serverSocket));
            new Thread(clientThread).start();
        }
    }
}
