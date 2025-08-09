package com.enset.app_chat_javafx_sockets_threads.client;



import java.io.*;
import java.net.Socket;

public class ChatClient {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public ChatClient(String host, int port) {
        try {
            socket = new Socket(host, port);
            System.out.println("Connected to chat server");

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true); // auto-flush
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Send message to server
    public void sendMessage(String message) {
        writer.println(message);
    }

    // Read a message from server
    public String readMessage() throws IOException {
        return reader.readLine();
    }

    // Close connection
    public void close() {
        try {
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BufferedReader getReader() {
        return reader;
    }

}
