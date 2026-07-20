USE staff_tracker_db;
CREATE TABLE tblDepartment (
    DepartmentID INT AUTO_INCREMENT PRIMARY KEY,
    DepartmentName VARCHAR(50)
);
CREATE TABLE tblManager (
    ManagerID INT AUTO_INCREMENT PRIMARY KEY,
    ManagerForename VARCHAR(30),
    ManagerSurname VARCHAR(30)
);
SHOW TABLES;
CREATE TABLE tblStaff (
    StaffID INT AUTO_INCREMENT PRIMARY KEY,
    StaffForename VARCHAR(30),
    StaffSurname VARCHAR(30),
    JobTitle VARCHAR(30),

    CONSTRAINT fk_staff_manager
        FOREIGN KEY (ManagerID)
        REFERENCES tblManager(ManagerID),

    CONSTRAINT fk_staff_department
        FOREIGN KEY (DepartmentID)
        REFERENCES tblDepartment(DepartmentID)
);
SHOW CREATE TABLE tblManager;
SHOW CREATE TABLE tblDepartment;
CREATE TABLE tblStaff (
    StaffID INT AUTO_INCREMENT PRIMARY KEY,
    StaffForename VARCHAR(30),
    StaffSurname VARCHAR(30),
    JobTitle VARCHAR(30),

    ManagerID INT,
    DepartmentID INT,

    CONSTRAINT fk_staff_manager
        FOREIGN KEY (ManagerID)
        REFERENCES tblManager(ManagerID),

    CONSTRAINT fk_staff_department
        FOREIGN KEY (DepartmentID)
        REFERENCES tblDepartment(DepartmentID)
);
SHOW TABLES;
SHOW CREATE TABLE tblStaff;
ALTER TABLE tblStaff
ADD `status` VARCHAR(9);
SHOW CREATE TABLE tblStaff;
ALTER TABLE tblStaff
RENAME COLUMN `status` TO `Status`;
SHOW TABLES;
ALTER TABLE tblStaff
MODIFY COLUMN `Status` VARCHAR(10);
INSERT INTO tblDepartment (DepartmentName) VALUES
('Marketing'),
('Developing'),
('Human Resources');

INSERT INTO tblManager (ManagerForename, ManagerSurname) VALUES
('John', 'Smith'),
('David', 'Brown'),
('Heather', 'Evans');

INSERT INTO tblStaff (StaffForename, StaffSurname, JobTitle, Status, ManagerID, DepartmentID) VALUES
('James', 'Wright', 'Brand Strategist', 'Permanent', 1, 1),
('Aisha', 'Begum', 'Software Developer', 'Permanent', 2, 2),
('Tom', 'Hughes', 'Junior Developer', 'Contractor', 2, 2),
('Grace', 'Lee', 'HR Officer', 'Permanent', 3, 3),
('Mohammed', 'Ali', 'Marketing Analyst', 'Contractor', 1, 1),
('Ellie', 'Robson', 'Recruiter', 'Permanent', 3, 3),
('Carl', 'Jones', 'DevOps Engineer', 'Permanent', 2, 2),
('Nadia', 'Hassan', 'Payroll Administrator', 'Contractor', 1, 1);
SHOW TABLES;
SELECT StaffForename, StaffSurname
FROM tblStaff
WHERE Status = 'Contractor' AND DepartmentID = 2;