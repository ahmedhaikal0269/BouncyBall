package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Stage stage;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        App.stage = stage;
        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
        stage.setTitle("Bouncy Ball");
        stage.show();
    }

    static void setRoot(int numBalls, Color selectedColor){
        BouncyBallPane pane = new BouncyBallPane(numBalls, selectedColor);
        Scene scene = new Scene(pane, 600, 400);
        stage.setScene(scene);
        pane.generateBalls();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}