package com.VishalProject.AirBnbProject.AirBnbApp.repository;

import com.VishalProject.AirBnbProject.AirBnbApp.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
