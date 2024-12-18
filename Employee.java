package com.hrmanagement.models;

import java.util.Date;

public class Employee {
    private int eid;
    private String initial;
    private String firstname;
    private String middlename;
    private String lastname;
    private String designation;
    private Date dob;
    private Date dateOfJoin;
    private String ftype;
    private String nationality;
    private String phone;
    private String email;
    private String caste;
    private String doorno;
    private String city;
    private String state;
    private int pincode;
    private String gender;
    private String profexpDesignation;
    private Date profexpFrom;
    private Date profexpTo;
    private int leaveMl;
    private int leaveLop;
    private int leaveRh;
    private int leaveOod;
    private int leaveCl;
    private int did;

    // Constructor
    public Employee(int eid, String initial, String firstname, String middlename, String lastname, String designation,
                    Date dob, Date dateOfJoin, String ftype, String nationality, String phone, String email, String caste,
                    String doorno, String city, String state, int pincode, String gender, String profexpDesignation,
                    Date profexpFrom, Date profexpTo, int leaveMl, int leaveLop, int leaveRh, int leaveOod, int leaveCl, int did) {
        this.eid = eid;
        this.initial = initial;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.designation = designation;
        this.dob = dob;
        this.dateOfJoin = dateOfJoin;
        this.ftype = ftype;
        this.nationality = nationality;
        this.phone = phone;
        this.email = email;
        this.caste = caste;
        this.doorno = doorno;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.gender = gender;
        this.profexpDesignation = profexpDesignation;
        this.profexpFrom = profexpFrom;
        this.profexpTo = profexpTo;
        this.leaveMl = leaveMl;
        this.leaveLop = leaveLop;
        this.leaveRh = leaveRh;
        this.leaveOod = leaveOod;
        this.leaveCl = leaveCl;
        this.did = did;
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
