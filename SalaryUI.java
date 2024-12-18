package com.hrmanagement.ui;

import com.hrmanagement.db.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalaryUI extends JFrame {
    private JTextField empIdField, basicSalaryField, agpField, esiField, loanField, itField;

    public SalaryUI() {
        setTitle("Manage Salary");
        setSize(400, 300);
        setLayout(new GridLayout(7, 2));

        add(new JLabel("Employee ID:"));
        empIdField = new JTextField();
        add(empIdField);

        add(new JLabel("Basic Salary:"));
        basicSalaryField = new JTextField();
        add(basicSalaryField);

        add(new JLabel("AGP:"));
        agpField = new JTextField();
        add(agpField);

        add(new JLabel("ESI:"));
        esiField = new JTextField();
        add(esiField);

        add(new JLabel("Loan:"));
        loanField = new JTextField();
        add(loanField);

        add(new JLabel("Income Tax:"));
        itField = new JTextField();
        add(itField);

        JButton addButton = new JButton("Add Salary");
        addButton.addActionListener(e -> addSalary());
        add(addButton);

        setVisible(true);
    }

    private void addSalary() {
        int empId = Integer.parseInt(empIdField.getText());
        double basicSalary = Double.parseDouble(basicSalaryField.getText());
        double agp = Double.parseDouble(agpField.getText());
        double esi = Double.parseDouble(esiField.getText());
        double loan = Double.parseDouble(loanField.getText());
        double it = Double.parseDouble(itField.getText());

        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO SALARY (EID, BASIC_SAL, AGP, ESI, LOAN, IT) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, empId);
            stmt.setDouble(2, basicSalary);
            stmt.setDouble(3, agp);
            stmt.setDouble(4, esi);
            stmt.setDouble(5, loan);
            stmt.setDouble(6, it);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Salary added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
