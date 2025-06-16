package com.example.assetManagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.assetManagment.entity.AssetRequest;
import java.util.List;

public interface AssetRequestRepository extends JpaRepository<AssetRequest, Integer> {
    List<AssetRequest> findByEmployeeId(int employeeId);
}
