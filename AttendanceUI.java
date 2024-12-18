package com.hrmanagement.ui;

import com.hrmanagement.db.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AttendanceUI extends JFrame {
    private JTextField empIdField, dateField, statusField;

    public AttendanceUI() {
        setTitle("Manage Attendance");
        setSize(400, 300);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Employee ID:"));
        empIdField = new JTextField();
        add(empIdField);

        add(new JLabel("Date (YYYY-MM-DD):"));
        dateField = new JTextField();
        add(dateField);

        add(new JLabel("Status (PRESENT/ABSENT):"));
        statusField = new JTextField();
        add(statusField);

        JButton addButton = new JButton("Add Attendance");
        addButton.addActionListener(e -> addAttendance());
        add(addButton);

        setVisible(true);
    }

    private void addAttendance() {
        int empId = Integer.parseInt(empIdField.getText());
        String date = dateField.getText();
        String status = statusField.getText();

        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO ATTENDANCE (EID, A_DATE, STATUS) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, empId);
            stmt.setString(2, date);
            stmt.setString(3, status);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Attendance added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
