package br.com.thread.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerTask {
    public static void main(String[] args) throws IOException {
        System.out.println("---- Iniciando Servidor ----");
        ServerSocket serverSocket = new ServerSocket(1212);

        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Aceitando conexão na porta " + socket.getPort());
            DistributeTasks distributeTasks = new DistributeTasks(socket);

            executorService.execute(distributeTasks);
            break;
        }
        serverSocket.close();
    }


}
