package com.VishalProject.AirBnbProject.AirBnbApp.repository;

import com.VishalProject.AirBnbProject.AirBnbApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
