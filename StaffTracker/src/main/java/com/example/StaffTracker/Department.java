package com.example.StaffTracker;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "tblDepartment")
public class Department {
    @Id
    @Column(name = "DepartmentID")
    private int departmentID;

    @Column(name = "DepartmentName")
    private String departmentName;

    public int getDepartmentID() { return departmentID; }
    public void setDepartmentID(int departmentID) { this.departmentID = departmentID; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

}
