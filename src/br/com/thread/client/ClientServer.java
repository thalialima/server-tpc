package br.com.thread.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientServer {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1212);
        System.out.println("Estabelecendo conexões");


        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        socket.close();
    }
}
