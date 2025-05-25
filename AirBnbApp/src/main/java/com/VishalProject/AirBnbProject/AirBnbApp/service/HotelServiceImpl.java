package com.VishalProject.AirBnbProject.AirBnbApp.service;


import com.VishalProject.AirBnbProject.AirBnbApp.dto.HotelDto;
import com.VishalProject.AirBnbProject.AirBnbApp.entity.Hotel;
import com.VishalProject.AirBnbProject.AirBnbApp.entity.Room;
import com.VishalProject.AirBnbProject.AirBnbApp.exception.ResourceNotFoundException;
import com.VishalProject.AirBnbProject.AirBnbApp.repository.HotelRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor // will automatically create the constructor for us no need to do it manually
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository;
    private final InventoryService inventoryService;
    private final ModelMapper modelMapper;

    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
        hotel.setActive(false);
        hotel= hotelRepository.save(hotel);
        log.info("Created a New Hotel with ID: {}", hotelDto.getId());
        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("Getting Hotel with ID: {}", id);
       Hotel hotel = hotelRepository.findById(id)
                      .orElseThrow(()-> new ResourceNotFoundException("Hotel Not Found with id: "+id));
        return modelMapper.map(hotel,HotelDto.class);  // Converting the Hotel into HotelDto using ModelMapper
    }

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
        // Firstly Need to get the hotel and then write its updation logic.
        log.info("Getting Hotel with ID: {}", id);
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel Not Found with id: "+id));
        // Map hotelDto to the Hotel souce nad destinatio
        modelMapper.map(hotelDto, hotel);
        hotel.setId(id);

        hotel = hotelRepository.save(hotel);
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    @Transactional
    public void deleteHotelById(Long id) {
        Hotel hotel = hotelRepository
                .findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Hotel not found with ID; "+ id));
        hotelRepository.deleteById(id);
        for(Room room : hotel.getRooms()){
            inventoryService.deleteFutureInventories(room);
        }


    }

    @Override
    @Transactional
    public void activeHotel(Long hoteId) {
        log.info("Activating the  Hotel with ID: {}", hoteId);
        Hotel hotel = hotelRepository.findById(hoteId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel Not Found with id: " + hoteId));
        hotel.setActive(true);
        //TODO create inventory for all the room for this hotel
        for(Room room : hotel.getRooms()){
            inventoryService.initializeRoomForAYear(room);
        }

    }
}
