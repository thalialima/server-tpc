package br.com.thread.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestQueue {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Queue");
        Queue<String> fila = new LinkedList<>();

        fila.offer("c1");
        fila.offer("c2");
        fila.offer("fim");

        //poll retorna e remove o elemento da fila
        System.out.println(fila.poll());
        System.out.println(fila.poll());

        //poll retorna mas não remove o elemento da fila
        System.out.println(fila.peek());
        System.out.println(fila.size());

        System.out.println("Blocking Queue");

        BlockingQueue<String> filaConcorrente = new ArrayBlockingQueue<>(3);

        filaConcorrente.put("c1");
        filaConcorrente.put("c2");
        filaConcorrente.put("fim");

        //take retorna e remove o elemento da fila
        System.out.println(filaConcorrente.take());
        System.out.println(filaConcorrente.take());
        System.out.println(filaConcorrente.take());
        System.out.println(filaConcorrente.take());

        System.out.println(filaConcorrente.size());



    }
}
