package com.VishalProject.AirBnbProject.AirBnbApp.controller;

import com.VishalProject.AirBnbProject.AirBnbApp.dto.RoomDto;
import com.VishalProject.AirBnbProject.AirBnbApp.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/hotels/{hotelId}/rooms")
@RequiredArgsConstructor
public class RoomAdminController {

    private  final RoomService roomService;

    // creating new room
    @PostMapping()
    public ResponseEntity<RoomDto> createNewRoom( @PathVariable Long hotelId,
                                                  @RequestBody RoomDto roomDto){
        RoomDto room = roomService.createNewRoom(hotelId, roomDto);
        return new ResponseEntity<>(room , HttpStatus.CREATED);
    }

    // Get all rooms within the hotel
    @GetMapping()
    public ResponseEntity<List<RoomDto>>  getAllRoomsInHotel(@PathVariable Long hotelId){
        return ResponseEntity.ok(roomService.getAllRoomsInHotel(hotelId));
    }
    // Get a room within the hotel
    @GetMapping("/{roomId}")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable Long hotelId, @PathVariable Long roomId){
        return ResponseEntity.ok(roomService.getRoomById(roomId));
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<RoomDto> deleteRoomById(@PathVariable Long hotelId, @PathVariable Long roomId){
        roomService.deleteRoomById(roomId);
        return ResponseEntity.noContent().build();

    }
}
