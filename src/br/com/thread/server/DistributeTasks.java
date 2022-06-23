package br.com.thread.server;

import java.net.Socket;
import java.util.Scanner;

public class DistributeTasks implements Runnable {
    private Socket socket;

    public DistributeTasks(Socket serverSocket) {
        this.socket = serverSocket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Distinbuindo tarefas para o cliente" + socket);
            Scanner inputClient = new Scanner(socket.getInputStream());

            while (inputClient.hasNextLine()) {
                String command = inputClient.nextLine();
                System.out.println(command);
            }
            inputClient.close();
            Thread.sleep(20000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
