package com.VishalProject.AirBnbProject.AirBnbApp.repository;

import com.VishalProject.AirBnbProject.AirBnbApp.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
