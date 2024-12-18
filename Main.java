package com.hrmanagement.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public MainApplication() {
        setTitle("HR Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton departmentButton = new JButton("Manage Departments");
        departmentButton.setBounds(100, 50, 200, 30);
        departmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DepartmentUI();
            }
        });
        add(departmentButton);

        JButton employeeButton = new JButton("Manage Employees");
        employeeButton.setBounds(100, 100, 200, 30);
        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeUI();
            }
        });
        add(employeeButton);

        JButton attendanceButton = new JButton("Attendance");
        attendanceButton.setBounds(100, 150, 200, 30);
        add(attendanceButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainApplication();
    }
}
