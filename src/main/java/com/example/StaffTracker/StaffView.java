package com.example.StaffTracker;
public class StaffView {
    
    private int staffID;
    private String staffForename;
    private String staffSurname;
    private String jobTitle;
    private String status;
    private String departmentName;
    private String lineManager;

    public StaffView(int staffID, String staffForename, String staffSurname,
                     String jobTitle, String status,
                     String departmentName, String lineManager) {
            
        this.staffID = staffID;
        this.staffForename = staffForename;
        this.staffSurname = staffSurname;
        this.jobTitle = jobTitle;
        this.status = status;
        this.departmentName = departmentName;
        this.lineManager = lineManager;
    }

    public int getStaffID() { return staffID; }
    public String getStaffForename() { return staffForename; }
    public String getStaffSurname() { return staffSurname; }
    public String getJobTitle() { return jobTitle; }
    public String getStatus() { return status; }
    public String getDepartmentName() { return departmentName; }
    public String getLineManager() { return lineManager; }
}

    

