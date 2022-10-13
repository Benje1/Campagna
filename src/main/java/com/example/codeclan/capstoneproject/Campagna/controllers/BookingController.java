package com.example.codeclan.capstoneproject.Campagna.controllers;

import com.example.codeclan.capstoneproject.Campagna.models.bookings.BandB;
import com.example.codeclan.capstoneproject.Campagna.models.bookings.Booking;
import com.example.codeclan.capstoneproject.Campagna.repositories.BandBRepository;
import com.example.codeclan.capstoneproject.Campagna.repositories.BookingRepository;
import com.example.codeclan.capstoneproject.Campagna.twilio.TwilioMessagingService;
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
    @Autowired
    BandBRepository bandBRepository;

//    @Value("${ACCOUNT_SID}")
//    String ACCOUNT_SID;
//
//    @Value("${AUTH_TOKEN}")
//    private String AUTH_TOKEN;

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
        Optional<BandB> bandb = bandBRepository.findById(booking.getBandb().getId());
        TwilioMessagingService messageService = new TwilioMessagingService();
        String message = String.format("Booking created.%n You have %s guests wanting to book from %s to %s.%n To confirm availability please go to - localhost:8080/bookings/%s/confirm %n If you have no availability please go to localhost:8080/bookings/%s/notavailable", booking.getNumberOfGuests(), booking.getStartDate(), booking.getEndDate(), booking.getId(), booking.getId());
        //This is commented out as you need a Twilio account to be able to send the text
//        messageService.send(ACCOUNT_SID, AUTH_TOKEN, bandb.get().getPhoneNumber(), message);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @PostMapping(value = "/bookings/{id}/confirm")
    public ResponseEntity<String> confirmBooking(@PathVariable Long id){
        Optional<Booking> booking = bookingRepository.findById(id);
        if(booking.isPresent()){
            booking.get().setStatus(true);
            booking.get().setAvailable(true);
            bookingRepository.save(booking.get());
            return new ResponseEntity<>("Thank you for confirming", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("There was an issue", HttpStatus.OK);
        }
    }

    @PostMapping(value = "/bookings/{id}/notavailable")
    public ResponseEntity<String > cannotFulfillBooking(@PathVariable Long id){
        Optional<Booking> booking = bookingRepository.findById(id);
        if(booking.isPresent()){
            booking.get().setStatus(true);
            bookingRepository.save(booking.get());
            return new ResponseEntity<>("We will let the client know", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("There was an issue", HttpStatus.OK);
        }
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
