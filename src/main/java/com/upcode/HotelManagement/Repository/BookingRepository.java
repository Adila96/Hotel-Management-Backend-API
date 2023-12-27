package com.upcode.HotelManagement.Repository;

import com.upcode.HotelManagement.Model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Bookings,Integer> {
}
