package com.VishalProject.AirBnbProject.AirBnbApp.entity;


import com.VishalProject.AirBnbProject.AirBnbApp.entity.enums.PayementStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table
public class Payement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String transcationId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PayementStatus payementStatus;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;


}
