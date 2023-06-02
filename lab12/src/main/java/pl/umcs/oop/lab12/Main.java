package pl.umcs.oop.lab12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GameCanvas gameCanvas = new GameCanvas();


        GridPane pane = new GridPane();
        pane.add(gameCanvas, 0, 0);
        stage.setScene(new Scene(pane));


        gameCanvas.initialize();
        gameCanvas.draw();
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}