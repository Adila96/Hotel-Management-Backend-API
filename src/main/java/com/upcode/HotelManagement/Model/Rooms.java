package com.upcode.HotelManagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rooms {
    @Id
    @GeneratedValue
    private int roomId;
    private int roomNo;
    @ManyToOne
    @JoinColumn(name="room_type_id")
    private RoomTypes roomType;
}
