module com.enset.app_chat_javafx_sockets_threads {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.enset.app_chat_javafx_sockets_threads to javafx.fxml;
    exports com.enset.app_chat_javafx_sockets_threads;
}