package com.example.SmartParkingSystem.controllers;

import com.example.SmartParkingSystem.dtos.parkingLot.ParkingLotCreateDTO;
import com.example.SmartParkingSystem.dtos.parkingLot.ParkingLotDTO;
import com.example.SmartParkingSystem.services.ParkingLotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/manager/lot")
public class ParkingLotController {
    private final ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PostMapping
    public ResponseEntity<Void> createParkingLotById(@RequestBody ParkingLotCreateDTO parkingLotCreateDTO) {
        parkingLotService.createParkingLot(parkingLotCreateDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ParkingLotDTO> getParkingLotById(@PathVariable Long id) {
        return ResponseEntity.ok(parkingLotService.findById(id));
    }


    @PutMapping
    public ResponseEntity<Void> updateParkingLotById(@RequestBody ParkingLotDTO parkingLotDTO) {
        parkingLotService.updateParkingLot(parkingLotDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteParkingLotById(@PathVariable Long id) {
        parkingLotService.deleteParkingLotById(id);
        return ResponseEntity.ok().build();
    }


}
