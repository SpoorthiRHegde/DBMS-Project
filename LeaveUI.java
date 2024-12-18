package com.hrmanagement.ui;

import com.hrmanagement.models.Leave;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LeaveUI {

    private Stage window;
    private ObservableList<Leave> leaveList;

    public LeaveUI() {
        leaveList = FXCollections.observableArrayList();
    }

    public void start(Stage primaryStage) {
        this.window = primaryStage;
        window.setTitle("Leave Management");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Leave type label and input
        Label ltypeLabel = new Label("Leave Type:");
        GridPane.setConstraints(ltypeLabel, 0, 0);
        TextField ltypeInput = new TextField();
        GridPane.setConstraints(ltypeInput, 1, 0);

        // No. of days label and input
        Label noOfDaysLabel = new Label("No. of Days:");
        GridPane.setConstraints(noOfDaysLabel, 0, 1);
        TextField noOfDaysInput = new TextField();
        GridPane.setConstraints(noOfDaysInput, 1, 1);

        // Add Leave Button
        Button addButton = new Button("Add Leave");
        GridPane.setConstraints(addButton, 1, 2);
        addButton.setOnAction(e -> addLeave(ltypeInput, noOfDaysInput));

        // Leave Table
        TableView<Leave> leaveTable = new TableView<>();
        TableColumn<Leave, String> ltypeColumn = new TableColumn<>("Leave Type");
        ltypeColumn.setCellValueFactory(cellData -> cellData.getValue().ltypeProperty());
        TableColumn<Leave, Integer> noOfDaysColumn = new TableColumn<>("No. of Days");
        noOfDaysColumn.setCellValueFactory(cellData -> cellData.getValue().noOfDaysProperty().asObject());

        leaveTable.setItems(leaveList);
        leaveTable.getColumns().addAll(ltypeColumn, noOfDaysColumn);

        // Layout setup
        grid.getChildren().addAll(ltypeLabel, ltypeInput, noOfDaysLabel, noOfDaysInput, addButton, leaveTable);

        Scene scene = new Scene(grid, 600, 400);
        window.setScene(scene);
        window.show();
    }

    private void addLeave(TextField ltypeInput, TextField noOfDaysInput) {
        String ltype = ltypeInput.getText();
        int noOfDays = Integer.parseInt(noOfDaysInput.getText());

        if (!ltype.isEmpty() && noOfDays > 0) {
            Leave leave = new Leave(leaveList.size() + 1, ltype, "Pending", noOfDays);
            leaveList.add(leave);
            ltypeInput.clear();
            noOfDaysInput.clear();
        } else {
            showAlert("Input Error", "Please fill in all fields correctly.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        LeaveUI leaveUI = new LeaveUI();
        leaveUI.start(new Stage());
    }
}
