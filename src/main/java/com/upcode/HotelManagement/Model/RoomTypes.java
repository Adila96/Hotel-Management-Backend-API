package com.upcode.HotelManagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomTypes {
    @Id
    private int roomTypeId;
    private String roomType;
    private int price;
    private String description;
    @OneToMany(mappedBy = "roomType")
    @JsonIgnore
    List<Rooms> rooms;

}
