package com.example.assetManagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.assetManagment.entity.ServiceRequest;
import java.util.List;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Integer> {
    List<ServiceRequest> findByEmployeeId(int employeeId);
}