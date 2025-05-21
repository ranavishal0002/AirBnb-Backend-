package com.VishalProject.AirBnbProject.AirBnbApp.dto;

import com.VishalProject.AirBnbProject.AirBnbApp.entity.HotelContactInfo;
import lombok.Data;

@Data
public class HotelDto {
    private Long id;
    private String name;
    private String city;
    private String[] photo;
    private String[]amenities;
    private HotelContactInfo contactInfo; // Whatever in HotelContactInfo we can get it here
    private Boolean active;


}
