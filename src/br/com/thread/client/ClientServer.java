package br.com.thread.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientServer {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1212);
        System.out.println("Estabelecendo conexões");

        PrintStream outPut = new PrintStream(socket.getOutputStream());
        Scanner inPut = new Scanner(socket.getInputStream());

        System.out.println("Enviando comando para o servidor...");

        Scanner keyboard = new Scanner(System.in);

        Thread sendCommands = new Thread(() -> {
            while (keyboard.hasNextLine()) {
                String command = keyboard.nextLine();
                outPut.println(command);

                if (command.trim().equals("")) {
                    break;
                }
            }
            outPut.close();
        });

        Thread receiveResponse = new Thread(() -> {
            while (inPut.hasNextLine()) {
                String response = inPut.nextLine();
                System.out.println("Resposta do servidor: ");
                System.out.println(response);
            }
            inPut.close();
        });

        sendCommands.start();
        receiveResponse.start();

        try {
            sendCommands.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Fechando o socket do cliente");

        socket.close();

    }
}
