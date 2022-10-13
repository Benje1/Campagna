package com.example.codeclan.capstoneproject.Campagna.components;

import com.example.codeclan.capstoneproject.Campagna.models.events.Event;
import com.example.codeclan.capstoneproject.Campagna.models.events.Trip;
import com.example.codeclan.capstoneproject.Campagna.repositories.EventRepository;
import com.example.codeclan.capstoneproject.Campagna.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EventTripDataLoader implements ApplicationRunner {

    @Autowired
    EventRepository eventRepository;
    @Autowired
    TripRepository tripRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Event event = new Event("Yom Kippor", "A Jewish holiday dedicated to seeking atonement for the past year and seeking to be better for the next", LocalDate.of(2022, 10, 4), LocalDate.of(2022, 10,5));
        Event event1 = new Event("Sunday Market", "A local market every Sunday where you can get local ingredients", LocalDate.of(2022, 10, 9), LocalDate.of(2022, 10, 9));
        Event event2 = new Event("Ardia", "A traditional horse race", LocalDate.of(2023, 7, 6), LocalDate.of(2023, 7, 7));
        eventRepository.save(event);
        eventRepository.save(event1);
        eventRepository.save(event2);
        Trip trip = new Trip("Mountains", "A short walk along the mountain range");
        Trip trip1 = new Trip("Forest", "A walk amongst the old trees of the forest");
        tripRepository.save(trip);
        tripRepository.save(trip1);
    }
}
