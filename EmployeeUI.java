package com.hrmanagement.ui;

import com.hrmanagement.models.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Date;

public class EmployeeUI {

    private Stage window;
    private ObservableList<Employee> employeeList;

    public EmployeeUI() {
        employeeList = FXCollections.observableArrayList();
    }

    public void start(Stage primaryStage) {
        this.window = primaryStage;
        window.setTitle("Employee Management");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Employee name label and input
        Label firstNameLabel = new Label("First Name:");
        GridPane.setConstraints(firstNameLabel, 0, 0);
        TextField firstNameInput = new TextField();
        GridPane.setConstraints(firstNameInput, 1, 0);

        // Employee email label and input
        Label emailLabel = new Label("Email:");
        GridPane.setConstraints(emailLabel, 0, 1);
        TextField emailInput = new TextField();
        GridPane.setConstraints(emailInput, 1, 1);

        // Add Employee Button
        Button addButton = new Button("Add Employee");
        GridPane.setConstraints(addButton, 1, 2);
        addButton.setOnAction(e -> addEmployee(firstNameInput, emailInput));

        // Employee Table
        TableView<Employee> employeeTable = new TableView<>();
        TableColumn<Employee, String> nameColumn = new TableColumn<>("Employee Name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().firstnameProperty());
        TableColumn<Employee, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        employeeTable.setItems(employeeList);
        employeeTable.getColumns().addAll(nameColumn, emailColumn);

        // Layout setup
        grid.getChildren().addAll(firstNameLabel, firstNameInput, emailLabel, emailInput, addButton, employeeTable);

        Scene scene = new Scene(grid, 600, 400);
        window.setScene(scene);
        window.show();
    }

    private void addEmployee(TextField firstNameInput, TextField emailInput) {
        String firstName = firstNameInput.getText();
        String email = emailInput.getText();

        if (!firstName.isEmpty() && !email.isEmpty()) {
            Employee employee = new Employee(employeeList.size() + 1, firstName, email);
            employeeList.add(employee);
            firstNameInput.clear();
            emailInput.clear();
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
        EmployeeUI employeeUI = new EmployeeUI();
        employeeUI.start(new Stage());
    }
}
