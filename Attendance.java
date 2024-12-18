package com.hrmanagement.models;

import java.sql.Time;
import java.util.Date;

public class Attendance {
    private int eid;
    private Date aDate;
    private String status;
    private Time login;
    private Time logout;

    // Constructor
    public Attendance(int eid, Date aDate, String status, Time login, Time logout) {
        this.eid = eid;
        this.aDate = aDate;
        this.status = status;
        this.login = login;
        this.logout = logout;
    }

    // Getters and Setters
    public int getEid() {
        return eid;
    }

    public Date getaDate() {
		return aDate;
	}

	public void setaDate(Date aDate) {
		this.aDate = aDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Time getLogin() {
		return login;
	}

	public void setLogin(Time login) {
		this.login = login;
	}

	public Time getLogout() {
		return logout;
	}

	public void setLogout(Time logout) {
		this.logout = logout;
	}

	public void setEid(int eid) {
        this.eid = eid;
    }

    // Similarly, create getters and setters for other fields...
}
