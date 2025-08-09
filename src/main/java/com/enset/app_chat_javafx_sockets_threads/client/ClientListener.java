package com.enset.app_chat_javafx_sockets_threads.client;



import java.io.BufferedReader;
import java.io.IOException;

public class ClientListener implements Runnable {

    private BufferedReader reader;

    public ClientListener(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println(message); // For now, just print to console
            }
        } catch (IOException e) {
            System.out.println("Disconnected from server");
        }
    }
}
