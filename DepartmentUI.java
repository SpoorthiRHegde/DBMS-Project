package com.hrmanagement.ui;

import com.hrmanagement.models.Department;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DepartmentUI {

    private Stage window;
    private ObservableList<Department> departmentList;

    public DepartmentUI() {
        departmentList = FXCollections.observableArrayList();
    }

    public void start(Stage primaryStage) {
        this.window = primaryStage;
        window.setTitle("Department Management");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Department name label and input
        Label dnameLabel = new Label("Department Name:");
        GridPane.setConstraints(dnameLabel, 0, 0);
        TextField dnameInput = new TextField();
        GridPane.setConstraints(dnameInput, 1, 0);

        // Department head label and input
        Label dheadLabel = new Label("Department Head:");
        GridPane.setConstraints(dheadLabel, 0, 1);
        TextField dheadInput = new TextField();
        GridPane.setConstraints(dheadInput, 1, 1);

        // Add Department Button
        Button addButton = new Button("Add Department");
        GridPane.setConstraints(addButton, 1, 2);
        addButton.setOnAction(e -> addDepartment(dnameInput, dheadInput));

        // Department Table
        TableView<Department> departmentTable = new TableView<>();
        TableColumn<Department, String> nameColumn = new TableColumn<>("Department Name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().dnameProperty());
        TableColumn<Department, String> headColumn = new TableColumn<>("Department Head");
        headColumn.setCellValueFactory(cellData -> cellData.getValue().dheadProperty());

        departmentTable.setItems(departmentList);
        departmentTable.getColumns().addAll(nameColumn, headColumn);

        // Layout setup
        grid.getChildren().addAll(dnameLabel, dnameInput, dheadLabel, dheadInput, addButton, departmentTable);

        Scene scene = new Scene(grid, 600, 400);
        window.setScene(scene);
        window.show();
    }

    private void addDepartment(TextField dnameInput, TextField dheadInput) {
        String dname = dnameInput.getText();
        String dhead = dheadInput.getText();

        if (!dname.isEmpty() && !dhead.isEmpty()) {
            Department department = new Department(departmentList.size() + 1, dname, dhead);
            departmentList.add(department);
            dnameInput.clear();
            dheadInput.clear();
        } else {
            showAlert("Input Error", "Please fill in both fields.");
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
        DepartmentUI departmentUI = new DepartmentUI();
        departmentUI.start(new Stage());
    }
}
