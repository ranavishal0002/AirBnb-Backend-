package com.VishalProject.AirBnbProject.AirBnbApp.dto;


import com.VishalProject.AirBnbProject.AirBnbApp.entity.Hotel;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RoomDto {
    private Long id;
    private String type;
    private BigDecimal price;
    private String[] photo;
    private String[]amenities;
    private Integer totalCount;
    private Integer capacity;

}
