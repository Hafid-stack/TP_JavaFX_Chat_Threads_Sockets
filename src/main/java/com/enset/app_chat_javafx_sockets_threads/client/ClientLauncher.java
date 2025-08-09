package com.enset.app_chat_javafx_sockets_threads.client;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientLauncher {
    public static void main(String[] args) throws IOException {
        // Connect to the server
        ChatClient client = new ChatClient("localhost", 5555);

        // Start a thread to listen for incoming messages
        Thread listenerThread = new Thread(new ClientListener(client.getReader()));
        listenerThread.start();

        // Read from console and send messages to the server
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = consoleReader.readLine()) != null) {
            client.sendMessage(input);
        }
    }
}
