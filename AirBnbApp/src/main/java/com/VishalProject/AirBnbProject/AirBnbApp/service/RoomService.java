package com.VishalProject.AirBnbProject.AirBnbApp.service;


import com.VishalProject.AirBnbProject.AirBnbApp.dto.RoomDto;

import java.util.List;

public interface RoomService  {

    RoomDto createNewRoom(Long hotelId, RoomDto roomDto);

    List<RoomDto> getAllRoomsInHotel(Long hotelId);

    RoomDto getRoomById(Long roomId);

    void deleteRoomById (Long roomId);
}
