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


CREATE TABLE service_request (
    id INT PRIMARY KEY AUTO_INCREMENT,
    assetId INT,
    employeeId INT,
    issueType VARCHAR(50), 
    description TEXT,
    status VARCHAR(20),
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

-- Insert into employee
INSERT INTO employee (name, email, password) VALUES
('Aditi Patil', 'aditi@example.com', 'aditi@123'),
('Rohan Mehta', 'rohan@example.com', 'rohan@123'),
('Sneha Kulkarni', 'sneha@example.com', 'sneha@123'),
('Aman Verma', 'aman@example.com', 'aman@123'),
('Pooja Shah', 'pooja@example.com', 'pooja@123');

-- Insert into admin
INSERT INTO admin (name, email, password) VALUES
('Admin One', 'admin1@asset.com', 'admin1pass'),
('Admin Two', 'admin2@asset.com', 'admin2pass'),
('Admin Three', 'admin3@asset.com', 'admin3pass'),
('Admin Four', 'admin4@asset.com', 'admin4pass'),
('Admin Five', 'admin5@asset.com', 'admin5pass');

-- Insert into asset
INSERT INTO asset (assetNo, assetName, category, status, assignedTo) VALUES
('A1001', 'Dell Laptop', 'Electronics', 'Assigned', 1),
('A1002', 'HP Monitor', 'Electronics', 'Assigned', 2),
('A1003', 'Office Chair', 'Furniture', 'Assigned', 3),
('A1004', 'iPhone SE', 'Electronics', 'Assigned', 4),
('A1005', 'Standing Desk', 'Furniture', 'Assigned', 5);

-- Insert into service_request
INSERT INTO service_request (assetId, employeeId, issueType, description, status) VALUES
(1, 1, 'Battery Issue', 'Laptop not charging properly.', 'Pending'),
(2, 2, 'Display Issue', 'Monitor screen flickering.', 'Resolved'),
(3, 3, 'Wheel Broken', 'Chair wheel is damaged.', 'Pending'),
(4, 4, 'Speaker Issue', 'No sound from phone.', 'Pending'),
(5, 5, 'Height Adjustment', 'Desk height mechanism stuck.', 'Resolved');


-- Insert into asset_request
INSERT INTO asset_request (employee_Id, assetName, category, status) VALUES
(1, 'MacBook Air', 'Electronics', 'Pending'),
(2, 'Ergonomic Mouse', 'Electronics', 'Approved'),
(3, 'Whiteboard', 'Stationery', 'Rejected'),
(4, 'Desk Lamp', 'Furniture', 'Pending'),
(5, 'Laptop Stand', 'Furniture', 'Approved');



