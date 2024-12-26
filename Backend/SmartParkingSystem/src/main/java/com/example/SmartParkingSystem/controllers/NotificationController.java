package com.example.SmartParkingSystem.controllers;


import com.example.SmartParkingSystem.models.dtos.NotificationDTO;
import com.example.SmartParkingSystem.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
@CrossOrigin("*")
public class NotificationController {

    private final NotificationService notificationService;


    @PostMapping("/create")
    public ResponseEntity<String> createNotification(@RequestBody NotificationDTO notificationDTO) {
        notificationService.createNotification(notificationDTO);
        return ResponseEntity.ok("Notification created successfully");
    }

    @GetMapping("/getNotifications/{driverID}")
    public ResponseEntity<List<NotificationDTO>> getNotifications(@PathVariable int driverID) {
        return null;
    }

    @PutMapping("/markAsRead/{notificationID}")
    public ResponseEntity<String> markAsRead(@PathVariable int notificationID) {
        return null;
    }

    @DeleteMapping("/deleteNotification/{notificationID}/{driverID}")
    public ResponseEntity<String> deleteNotification(@PathVariable int notificationID, @PathVariable int driverID) {
        return null;
    }

    @DeleteMapping("/deleteAllNotifications/{driverID}")
    public ResponseEntity<String> deleteAllNotifications(@PathVariable int driverID) {
        return null;
    }
 

}
