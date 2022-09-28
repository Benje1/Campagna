package com.example.codeclan.capstoneproject.Campagna.controllers;

import com.example.codeclan.capstoneproject.Campagna.models.bookings.Booking;
import com.example.codeclan.capstoneproject.Campagna.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBooking(){
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);

    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity<Optional<Booking>> getBandBById(@PathVariable Long id){
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/booking/status")
    public ResponseEntity<List<Booking>> getBookingByStatus(@RequestParam(name = "status") boolean status){
        return new ResponseEntity<>(bookingRepository.findByStatus(status), HttpStatus.OK);
    }

    @PostMapping(value = "/bookings")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @PostMapping(value = "/bookings/{id}/confirm")
    public ResponseEntity<String> confirmBooking(@PathVariable Long id){
        Optional<Booking> booking = bookingRepository.findById(id);
        if(booking.isPresent()){
            booking.get().setStatus(true);
            booking.get().setAvailable(true);
        }
        return new ResponseEntity<>("Thank you for confirming", HttpStatus.OK);
    }

    @PostMapping(value = "/booking/{id}/notavailable")
    public ResponseEntity<String> denyBooking(@PathVariable Long id){
        Optional<Booking> booking = bookingRepository.findById(id);
        if(booking.isPresent()){
            booking.get().setStatus(true);
        }
        return new ResponseEntity<>("We will let the clients know", HttpStatus.OK);
    }
}