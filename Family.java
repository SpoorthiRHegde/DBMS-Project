package com.hrmanagement.models;

import java.util.Date;

public class Family {
    private int eid;
    private String fname;
    private Date fdob;
    private String mname;
    private Date mdob;

    // Constructor
    public Family(int eid, String fname, Date fdob, String mname, Date mdob) {
        this.eid = eid;
        this.fname = fname;
        this.fdob = fdob;
        this.mname = mname;
        this.mdob = mdob;
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
