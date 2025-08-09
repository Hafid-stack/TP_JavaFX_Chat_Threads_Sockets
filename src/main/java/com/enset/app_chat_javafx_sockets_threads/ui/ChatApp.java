package com.enset.app_chat_javafx_sockets_threads.ui;




import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/enset/app_chat_javafx_sockets_threads/fxml/chat.fxml"));

        Parent root = loader.load();

        stage.setTitle("JavaFX Chat");
        stage.setScene(new Scene(root, 600, 500));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
