package com.upcode.HotelManagement.Controller;

import com.upcode.HotelManagement.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rooms")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class RoomController {
    @Autowired
    RoomRepository roomRepository;
    @GetMapping("")
    ResponseEntity<?> showRooms(@RequestParam (value="roomtypeid",required = false) Integer roomTypeId){
        if(roomTypeId==null){
           return ResponseEntity.ok(roomRepository.findAll());
        }
        return ResponseEntity.ok(roomRepository.findByRoomTypeId(roomTypeId));
    }
}
