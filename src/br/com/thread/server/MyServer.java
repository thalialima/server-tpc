package br.com.thread.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class MyServer {

    private ServerSocket serverSocket;
    private ExecutorService executorService;
    private volatile boolean isRunning;

    // private AtomicBoolean isRunning;
    private BlockingQueue<String> commands;

    public MyServer() {
        try {
            this.serverSocket = new ServerSocket(1212);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.executorService = Executors.newCachedThreadPool();
        this.isRunning = true;
        this.commands = new ArrayBlockingQueue<>(2);
        startConsumers();
    }

    // na classe ServidorTarefas
    private void startConsumers() {
        int qtdConsumers= 2;
        for (int i = 0; i < qtdConsumers; i++) {
            TaskConsumer tarefa = new TaskConsumer(commands);
            this.executorService.execute(tarefa);
        }
    }

    public void start() throws IOException {
        System.out.println("---- Iniciando Servidor ----");
        while (this.isRunning) {
            try {
                Socket socket = this.serverSocket.accept();
                System.out.println("Aceitando conexão na porta " + socket.getPort());
                DistributeTasks distributeTasks = new DistributeTasks(socket, this, commands);

                executorService.execute(distributeTasks);
            } catch (SocketException e) {
                System.out.println("Terminando app");
            }

        }
    }

    public void stop() throws IOException {
        serverSocket.close();
        executorService.shutdown();
        this.isRunning = false;
    }
}

