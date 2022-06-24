package br.com.thread.server;

import java.util.concurrent.BlockingQueue;

public class TaskConsumer implements Runnable {

    private BlockingQueue<String> filaComandos;

    public TaskConsumer(BlockingQueue<String> filaComandos) {
        this.filaComandos = filaComandos;
    }

    @Override
    public void run() {
        try {
            String comando = null;

            //enquanto existe um novo comando, lembrando take() bloqueia
            while ((comando = filaComandos.take()) != null) {
                System.out.println("Consumindo comando " + comando + ", " + Thread.currentThread().getName());
                Thread.sleep(20000); //demorando 20s para consumir
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


