package com.upcode.HotelManagement.Controller;

import com.upcode.HotelManagement.Model.Bookings;
import com.upcode.HotelManagement.Model.Users;
import com.upcode.HotelManagement.Repository.BookingRepository;
import com.upcode.HotelManagement.Repository.UserRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<?> showAllBookings(){
        return ResponseEntity.ok(bookingRepository.findAll());
    }

    @GetMapping("/{bookingId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<?> showAllBookings(@PathVariable("bookingId") Integer bookingId){
        return ResponseEntity.ok(bookingRepository.findById(bookingId));
    }


    @PostMapping("/newbookings")
    @PreAuthorize("hasRole('ROLE_USER')")
    ResponseEntity<?> addBooking(@RequestBody Bookings bookings){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = (Users) authentication.getPrincipal();
        if (bookings==null){
            return ResponseEntity.badRequest().body("No bookings created!!");
        }
        Bookings newBooking=new Bookings();
        newBooking.setNoOfDays(bookings.getNoOfDays());
        newBooking.setUser(user);
        newBooking.setRoomType(bookings.getRoomType());
        return ResponseEntity.ok(bookingRepository.save(newBooking));
    }
    @DeleteMapping("delete/{bookingId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    ResponseEntity<?>deleteBooking(@PathVariable("bookingId") Integer bookingId){
        bookingRepository.deleteById(bookingId);
        return ResponseEntity.ok().body("Delete Successful");
    }

}
