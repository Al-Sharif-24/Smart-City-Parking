package com.example.SmartParkingSystem.dtos.parkingLot;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingLotDTO {
    private Long id;
    private String location;
    private String name;
    private Integer capacity;
    private Integer availableSpots;
    private BigDecimal basePrice;
    private BigDecimal demandFactor;
    private BigDecimal evFactor;
    private Integer timeLimit;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
