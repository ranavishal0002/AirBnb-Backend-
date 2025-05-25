package com.VishalProject.AirBnbProject.AirBnbApp.repository;

import com.VishalProject.AirBnbProject.AirBnbApp.entity.Inventory;
import com.VishalProject.AirBnbProject.AirBnbApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    void deleteByDateAfterAndRoom(LocalDate date, Room room);
}
