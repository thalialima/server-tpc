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

        System.out.println("Enviando comando para o servidor...");

        outPut.println("c1");

        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
        outPut.close();
        socket.close();


        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        socket.close();
    }
}
