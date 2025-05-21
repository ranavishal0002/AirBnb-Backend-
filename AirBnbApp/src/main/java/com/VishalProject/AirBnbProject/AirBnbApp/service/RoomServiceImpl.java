package com.VishalProject.AirBnbProject.AirBnbApp.service;

import com.VishalProject.AirBnbProject.AirBnbApp.dto.RoomDto;
import com.VishalProject.AirBnbProject.AirBnbApp.entity.Hotel;
import com.VishalProject.AirBnbProject.AirBnbApp.entity.Room;
import com.VishalProject.AirBnbProject.AirBnbApp.exception.ResourceNotFoundException;
import com.VishalProject.AirBnbProject.AirBnbApp.repository.HotelRepository;
import com.VishalProject.AirBnbProject.AirBnbApp.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomServiceImpl implements  RoomService{

    private  final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public RoomDto createNewRoom(Long hotelId, RoomDto roomDto) {
        log.info("Creating a new room in hotel with ID:{}", hotelId);
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel Not Found with id: "+hotelId));
        Room room = modelMapper.map(roomDto, Room.class);
        room.setHotel(hotel);
        room = roomRepository.save(room);
        // TODO create room inventory as soon as room created ans hotel is active
        return  modelMapper.map(room, RoomDto.class);
    }

    @Override
    public List<RoomDto> getAllRoomsInHotel(Long hotelId) {
        log.info("Getting all rooms in hotel with ID:{}", hotelId);
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel Not Found with id: "+hotelId));
        return hotel.getRooms()
                .stream()
                .map((element)-> modelMapper.map(element, RoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomById(Long roomId) {
        return null;
    }

    @Override
    public void deleteRoomById(Long roomId) {

    }
}
