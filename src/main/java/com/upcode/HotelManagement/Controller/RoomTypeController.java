package com.upcode.HotelManagement.Controller;

import com.upcode.HotelManagement.Model.RoomTypes;
import com.upcode.HotelManagement.Repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/room-types")

public class RoomTypeController {
    @Autowired
    RoomTypeRepository roomTypeRepository;
    @RequestMapping(value="")
    @PreAuthorize("hasRole('ROLE_USER')")
     ResponseEntity<?> showRoomType(){
         return ResponseEntity.ok(roomTypeRepository.findAll());

    }
    @RequestMapping("/{roomTypeId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<?> showRoomTypeById(@PathVariable("roomTypeId") Integer id){
        Optional<RoomTypes> optionalRoomType=roomTypeRepository.findById(id);
        if(optionalRoomType.isEmpty()) {
            return ResponseEntity.badRequest().body("Not Found");
        }else{
            return ResponseEntity.ok(roomTypeRepository.findById(id));
        }
    }

    @RequestMapping(value = "/{roomTypeId}",method = RequestMethod.PUT)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<?>updateRoomTypeById(@PathVariable("roomTypeId") Integer id,@RequestBody RoomTypes roomType){
        Optional<RoomTypes> optionalRoomType=roomTypeRepository.findById(id);
        if(optionalRoomType.isEmpty()){
            return ResponseEntity.badRequest().body("Not Found");
        }else {
            RoomTypes existingRoomType=optionalRoomType.get();
            existingRoomType.setRoomType(roomType.getRoomType());
            existingRoomType.setPrice(roomType.getPrice());
            existingRoomType.setDescription(roomType.getDescription());
            return ResponseEntity.ok(roomTypeRepository.save(existingRoomType));
        }
    }

}
