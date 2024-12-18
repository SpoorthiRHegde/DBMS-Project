package com.hrmanagement.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("HR Management System");

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

        // Add a simple alert on launch
        showWelcomeMessage();
    }

    private void showWelcomeMessage() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Welcome");
        alert.setHeaderText("HR Management System");
        alert.setContentText("Welcome to the HR Management System!");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
