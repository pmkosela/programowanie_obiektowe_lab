module pl.umcs.oop.lab12 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens pl.umcs.oop.lab12 to javafx.fxml;
    exports pl.umcs.oop.lab12;
}