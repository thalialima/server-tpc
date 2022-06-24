package br.com.thread.server;

import java.io.IOException;

public class MainTask {
    public static void main(String[] args) throws IOException {

        MyServer serverMain = new MyServer();
        serverMain.start();
        serverMain.stop();

    }


}
