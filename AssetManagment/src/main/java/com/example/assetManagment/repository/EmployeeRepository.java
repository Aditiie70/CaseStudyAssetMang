package com.example.assetManagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.assetManagment.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmailAndPassword(String email, String password);
}
