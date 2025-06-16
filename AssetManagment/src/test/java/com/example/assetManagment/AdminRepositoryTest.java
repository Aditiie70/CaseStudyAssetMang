package com.example.assetManagment;

import com.example.assetManagment.entity.Admin;
import com.example.assetManagment.repository.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AdminRepositoryTest {

    @Autowired
    private AdminRepository adminRepo;

    private Admin testAdmin;

    @BeforeEach
    public void setUp() {
        testAdmin = new Admin();
        testAdmin.setName("Add1");
        testAdmin.setEmail("add3@example.com");
        testAdmin.setPassword("add123");

        adminRepo.save(testAdmin);
    }

    @Test
    public void testFindByEmailAndPassword_Success() {
        Admin found = adminRepo.findByEmailAndPassword("add3@example.com", "add123");
        assertNotNull(found);
        assertEquals("Add1", found.getName());
    }

   
}
