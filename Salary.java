package com.hrmanagement.models;

public class Salary {
    private int eid;
    private double basicSal;
    private double agp;
    private double esi;
    private double loan;
    private double it;

    // Constructor
    public Salary(int eid, double basicSal, double agp, double esi, double loan, double it) {
        this.eid = eid;
        this.basicSal = basicSal;
        this.agp = agp;
        this.esi = esi;
        this.loan = loan;
        this.it = it;
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
