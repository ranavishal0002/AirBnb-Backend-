package com.VishalProject.AirBnbProject.AirBnbApp.controller;

import com.VishalProject.AirBnbProject.AirBnbApp.dto.RoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/hotels/{hotelId}/rooms")
@RequiredArgsConstructor
public class RoomAdminController {

    @PostMapping()
    public ResponseEntity<RoomDto> createNewRoom(@RequestBody RoomDto roomDto){

    }

}
