module com.example.clientgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires lab10.client;


    opens com.example.clientgui to javafx.fxml;
    exports com.example.clientgui;
}