package com.hrmanagement.models;

public class Leave {
    private int eid;
    private String ltype;
    private String approval;
    private int noOfDays;

    // Constructor
    public Leave(int eid, String ltype, String approval, int noOfDays) {
        this.eid = eid;
        this.ltype = ltype;
        this.approval = approval;
        this.noOfDays = noOfDays;
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
