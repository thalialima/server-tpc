package br.com.thread.view;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TaskReceivesResponse implements Runnable {
    private Socket socket;
    private GraphicInterface interfaceGrafica;

    public TaskReceivesResponse(Socket socket, GraphicInterface ig) {
        this.socket = socket;
        this.interfaceGrafica = ig;
    }

    @Override
    public void run() {
        try {
            interfaceGrafica.imprime("Recebendo dados do servidor");
            Scanner respostaServidor = new Scanner(socket.getInputStream());

            while (respostaServidor.hasNextLine()) {
                String linha = respostaServidor.nextLine();
                interfaceGrafica.imprime(linha);
            }

            respostaServidor.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

