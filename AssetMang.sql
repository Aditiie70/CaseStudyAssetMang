CREATE DATABASE Assetmang;
USE Assetmang;

-- Employee Table
CREATE TABLE employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);

--  Admin Table
CREATE TABLE admin (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);

-- Asset Table
CREATE TABLE asset (
    id INT PRIMARY KEY AUTO_INCREMENT,
    assetNo VARCHAR(50),
    assetName VARCHAR(100),
    category VARCHAR(50),
    status VARCHAR(20), 
    assignedTo INT,
    FOREIGN KEY (assignedTo) REFERENCES employee(id)
);

-- Service Request Table
CREATE TABLE service_request (
    id INT PRIMARY KEY AUTO_INCREMENT,
    assetId INT,
    employeeId INT,
    issueType VARCHAR(50), 
    description TEXT,
    status VARCHAR(20), -- Pending, Resolved
    FOREIGN KEY (assetId) REFERENCES asset(id),
    FOREIGN KEY (employeeId) REFERENCES employee(id)
);

-- Asset Request Table (for tracking new asset requests)
CREATE TABLE asset_request (
    id INT PRIMARY KEY AUTO_INCREMENT,
    employeeId INT,
    assetName VARCHAR(100),
    category VARCHAR(50),
    status VARCHAR(20), -- Pending, Approved, Rejected
    requestDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (employeeId) REFERENCES employee(id)
);


