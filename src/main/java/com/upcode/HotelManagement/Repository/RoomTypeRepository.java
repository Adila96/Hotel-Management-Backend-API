package com.upcode.HotelManagement.Repository;

import com.upcode.HotelManagement.Model.RoomTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomTypeRepository extends JpaRepository<RoomTypes, Integer> {

    RoomTypes findByRoomTypeIgnoreCase(String room_type);
}
