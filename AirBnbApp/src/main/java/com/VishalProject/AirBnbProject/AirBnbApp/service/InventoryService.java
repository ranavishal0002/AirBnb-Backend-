package com.VishalProject.AirBnbProject.AirBnbApp.service;

import com.VishalProject.AirBnbProject.AirBnbApp.entity.Room;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteFutureInventories( Room room);

}
