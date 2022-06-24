package br.com.thread.server;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DistributeTasks implements Runnable {
    private MyServer mainServer;
    private Socket socket;

    public DistributeTasks(Socket serverSocket, MyServer mainServer) {
        this.socket = serverSocket;
        this.mainServer = mainServer;
    }

    @Override
    public void run() {
        try {
            System.out.println("Distinbuindo tarefas para o cliente" + socket);
            Scanner inputClient = new Scanner(socket.getInputStream());
            PrintStream outputServer = new PrintStream(socket.getOutputStream());

            while (inputClient.hasNextLine()) {
                String command = inputClient.nextLine();
                if(command.trim().equals(""))
                    break;

                switch (command){
                    case "c1" :
                        System.out.println("comando c1 recebido");
                        outputServer.println("Respondendo comando c1");
                        break;
                    case "c2" :
                        System.out.println("Recebendo comando c2");
                        outputServer.println("Respondendo comando c2");
                        break;
                    case "fim" :
                        System.out.println("Parando servidor principal");
                        this.mainServer.stop();
                        break;
                    default:
                        System.out.println("Nenhum válido comando recebido!");
                        outputServer.println("Esperando comando válido");
                }
                System.out.println(command);
            }

            inputClient.close();
            outputServer.close();
            socket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
