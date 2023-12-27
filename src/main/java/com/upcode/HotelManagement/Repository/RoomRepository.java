package com.upcode.HotelManagement.Repository;

import com.upcode.HotelManagement.Model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Rooms,Integer> {
    @Query(value="select * from rooms where room_type_id=:roomTypeId",nativeQuery = true)
    List<Rooms> findByRoomTypeId(Integer roomTypeId);

}
