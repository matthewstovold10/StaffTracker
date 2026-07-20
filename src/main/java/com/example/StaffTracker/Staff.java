package com.example.StaffTracker;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "tblStaff")


public class Staff {
    
    @Id
    @Column(name = "StaffID")
    private int staffID;

    @Column(name = "StaffForename")
    private String staffForename;

    @Column(name = "StaffSurname")
    private String staffSurname;

    @Column(name = "JobTitle")
    private String jobTitle;

    @Column(name = "Status")
    private String status;

    @Column(name = "ManagerID")
    private int managerID;

    @Column(name = "DepartmentID")
    private int departmentID;

    public int getStaffID() { return staffID; }
    public void setStaffID(int staffID) { this.staffID = staffID; }
        
    public String getStaffForename() { return staffForename; }
    public void setStaffForename(String staffForename) { this.staffForename = staffForename; }

    public String getStaffSurname() { return staffSurname; }
    public void setStaffSurname(String staffSurname) { this.staffSurname = staffSurname; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    int getManagerID() { return managerID; }
    public void setManagerID(int managerID) { this.managerID = managerID; }

    int getDepartmentID() { return departmentID; }
    public void setDepartmentID(int departmentID) { this.departmentID = departmentID; }

}
