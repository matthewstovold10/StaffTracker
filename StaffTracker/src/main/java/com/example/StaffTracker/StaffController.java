package com.example.StaffTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @GetMapping("/staff")
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @GetMapping("/staff/full")
    public List<StaffView> getAllStaffWithDetails() {
        return staffRepository.findAllWithDetails();
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @GetMapping("/managers")
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @DeleteMapping("staff/{id}")
    public void deleteStaff(@PathVariable int id) {
        staffRepository.deleteById(id);
    }
    
    @PostMapping("/staff")
    public Staff addStaff(@RequestBody Staff staff) {
        return staffRepository.save(staff);
    }
}
