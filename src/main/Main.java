package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Turn-Based RPG");

        GamePanel gamePanel = new GamePanel(); // JavaFX version of GamePanel
        Scene scene = new Scene(gamePanel, 800, 600); // Adjust dimensions as needed

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();

        gamePanel.startGameLoop(); // Start game logic
    }

    
    public static void main(String[] args) {
        launch(args);
    }
}
