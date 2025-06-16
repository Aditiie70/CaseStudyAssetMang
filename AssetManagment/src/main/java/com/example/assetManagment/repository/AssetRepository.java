package com.example.assetManagment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.assetManagment.entity.Asset;
import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Integer> {
    List<Asset> findByAssignedTo(Integer employeeId);
}