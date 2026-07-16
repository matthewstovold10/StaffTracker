package com.example.StaffTracker;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "tblManager")
public class Manager {
    @Id
    @Column(name = "ManagerID")
    private int managerID;

    @Column(name = "ManagerForename")
    private String managerForename;

    @Column(name = "ManagerSurname")
    private String managerSurname;

    public int getManagerID() { return managerID; }
    public void setManagerID(int managerID) { this.managerID = managerID; }

    public String getManagerForename() { return managerForename; }
    public void setManagerForename(String managerForename) { this.managerForename = managerForename; }
    
    public String getManagerSurname() { return managerSurname; }
    public void setManagerSurname(String managerSurname) { this.managerSurname = managerSurname; }

}


