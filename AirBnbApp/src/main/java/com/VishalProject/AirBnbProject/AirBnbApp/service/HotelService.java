package com.VishalProject.AirBnbProject.AirBnbApp.service;

import com.VishalProject.AirBnbProject.AirBnbApp.dto.HotelDto;
import com.VishalProject.AirBnbProject.AirBnbApp.entity.Hotel;
import org.apache.el.parser.BooleanNode;

public interface HotelService {
    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id, HotelDto hotelDto);

    void deleteHotelById(Long id);

    void activeHotel(Long hoteId);
}
