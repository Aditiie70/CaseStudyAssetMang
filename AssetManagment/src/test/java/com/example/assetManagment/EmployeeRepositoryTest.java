package com.example.assetManagment;

import com.example.assetManagment.entity.Employee;
import com.example.assetManagment.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest  
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepo;

    private Employee testEmployee;

    @BeforeEach  
    public void setup() {
        testEmployee = new Employee();
        testEmployee.setName("pqr");
        testEmployee.setEmail("pqr@example.com");
        testEmployee.setPassword("pqr123");
        
        employeeRepo.save(testEmployee);
        
        
    }

    @Test
    public void testFindByEmailAndPassword() {
        Employee found = employeeRepo.findByEmailAndPassword("pqr@example.com", "pqr123");
        assertNotNull(found);
        assertEquals("pqr", found.getName());
    }

  
}
