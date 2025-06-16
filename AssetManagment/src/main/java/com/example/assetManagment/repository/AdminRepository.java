package com.example.assetManagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.assetManagment.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByEmailAndPassword(String email, String password);
}