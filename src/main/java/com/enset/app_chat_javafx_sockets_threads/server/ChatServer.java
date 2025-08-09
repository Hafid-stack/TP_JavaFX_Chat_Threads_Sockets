package com.enset.app_chat_javafx_sockets_threads.server;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

    private ServerSocket serverSocket;
    private List<ClientHandler> clients = new ArrayList<>();

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();  // Wait for a client
                System.out.println("New client connected");

                ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                clients.add(clientHandler);

                new Thread(clientHandler).start(); // Start the client thread
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to broadcast a message to all clients
    public synchronized void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    // Method to remove a client when it disconnects
    public synchronized void removeClient(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        System.out.println("Client disconnected");
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.start(5555);
    }
}

