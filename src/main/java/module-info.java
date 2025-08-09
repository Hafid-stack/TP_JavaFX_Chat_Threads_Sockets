module com.enset.app_chat_javafx_sockets_threads {
    requires javafx.controls;
    requires javafx.fxml;

    // Open the ui package to javafx.fxml so FXML loader can access controllers
    opens com.enset.app_chat_javafx_sockets_threads.ui to javafx.fxml;

    // Export the ui package so JavaFX can instantiate your Application subclass
    exports com.enset.app_chat_javafx_sockets_threads.ui;

    // Keep the root package opened and exported if you use it for anything FXML related
    opens com.enset.app_chat_javafx_sockets_threads to javafx.fxml;
    exports com.enset.app_chat_javafx_sockets_threads;
}
