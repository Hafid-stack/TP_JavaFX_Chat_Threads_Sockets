package com.enset.app_chat_javafx_sockets_threads.ui;


import com.enset.app_chat_javafx_sockets_threads.client.ChatClient;
import com.enset.app_chat_javafx_sockets_threads.client.ClientListener;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;

public class ChatController {

    @FXML
    private TextArea chatArea;

    @FXML
    private TextField inputField;

    private ChatClient client;

    @FXML
    public void initialize() {
        // Connect to the server
        client = new ChatClient("localhost", 5555);

        // Start listener thread to receive messages
        BufferedReader reader = client.getReader();
        Thread listenerThread = new Thread(new ClientListener(reader) {
            @Override
            public void run() {
                String message;
                try {
                    while ((message = reader.readLine()) != null) {
                        final String msg = message;
                        Platform.runLater(() -> chatArea.appendText(msg + "\n"));
                    }
                } catch (IOException e) {
                    Platform.runLater(() -> chatArea.appendText("Disconnected from server\n"));
                }
            }
        });
        listenerThread.setDaemon(true);
        listenerThread.start();
    }

    @FXML
    private void handleSend() {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            client.sendMessage(message);
            inputField.clear();
        }
    }
}
