package org.example.DemoModul6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.DemoModul6.com.main.LibrarySystem;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Button button = new Button("Start Library System");
        button.setOnAction(event -> LibrarySystem.startLibrarySystem(stage));

        VBox root = new VBox(10, button);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 500, 600);

        stage.setTitle("Library System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
