module com.example.clientgui {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.clientgui to javafx.fxml;
    exports com.example.clientgui;
}