package com.hrmanagement.models;

public class Department {
    private int did;
    private String dname;
    private String dhead;

    // Constructor
    public Department(int did, String dname, String dhead) {
        this.did = did;
        this.dname = dname;
        this.dhead = dhead;
    }

    // Getters and Setters
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDhead() {
        return dhead;
    }

    public void setDhead(String dhead) {
        this.dhead = dhead;
    }
}
