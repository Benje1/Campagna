package com.example.codeclan.capstoneproject.Campagna.user;

import com.example.codeclan.capstoneproject.Campagna.accomodations.models.Accommodation;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hosts")
public class Host extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private List<Accommodation> accommodations;

    public Host(String name, String info) {
        super(name, info);
        this.accommodations = new ArrayList<>();
    }

    public int getNumberOfAccommodations(){
        return this.accommodations.size();
    }

    public void addAccommodation(Accommodation accommodation){
        this.accommodations.add(accommodation);
    }

    public void makeBooking(int year, int month, int day, int numberOfDays, int numberOfGuests){
        int numberOfGuestsNeedingToBeBooked = numberOfGuests;
        for(Accommodation accommodation : this.accommodations){
            while(numberOfGuestsNeedingToBeBooked > 0){
                numberOfGuestsNeedingToBeBooked -= accommodation.makeBooking(year, month, day, numberOfDays, numberOfGuests);
            }
        }
    }

    public List<LocalDate> getDaysBooked(){
        List<LocalDate> bookedDays = new ArrayList<>();
        for(Accommodation accommodation : this.accommodations){
            bookedDays.addAll(accommodation.getBookedDays());
        }
        return bookedDays;
    }

}
