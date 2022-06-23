package br.com.thread.view;

import java.io.IOException;
import java.net.Socket;

public class RunApp {
    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 1212)) {

            GraphicInterface ig = new GraphicInterface(socket);
            ig.montaTela();
            ig.imprime("Conexão estabelicada com sucesso");
            initializaThreadQueRecebeAResposta(socket, ig);
            ig.imprime("Servidor fechado");

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void initializaThreadQueRecebeAResposta(Socket socket, GraphicInterface ig)
            throws InterruptedException {

        Runnable threadRecebeResposta = new TaskReceivesResponse(socket, ig);
        Thread threadResposta = new Thread(threadRecebeResposta);
        threadResposta.start();
        threadResposta.join(); //MAIN vai espearar a threadResposta terminar
    }

}

