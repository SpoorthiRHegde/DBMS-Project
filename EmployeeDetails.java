package com.hrmanagement.models;

public class EmployeeDetails {
    private int eid;
    private String biometricCardNo;
    private String aadhar;
    private String bankAcc;
    private String pan;

    // Constructor
    public EmployeeDetails(int eid, String biometricCardNo, String aadhar, String bankAcc, String pan) {
        this.eid = eid;
        this.biometricCardNo = biometricCardNo;
        this.aadhar = aadhar;
        this.bankAcc = bankAcc;
        this.pan = pan;
    }

    // Getters and Setters
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    // Similarly, create getters and setters for other fields...
}
