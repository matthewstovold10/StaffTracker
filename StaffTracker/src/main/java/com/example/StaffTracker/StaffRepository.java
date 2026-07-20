package com.example.StaffTracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    @Query("SELECT new com.example.StaffTracker.StaffView(" +
           "s.staffID, s.staffForename, s.staffSurname, s.jobTitle, s.status, " +
           "d.departmentName, CONCAT(m.managerForename, ' ', m.managerSurname)) " +
           "FROM Staff s " +
           "LEFT JOIN Department d ON s.departmentID = d.departmentID " +
           "LEFT JOIN Manager m ON s.managerID = m.managerID")
    List<StaffView> findAllWithDetails();
    
}


