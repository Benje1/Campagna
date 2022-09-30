package com.example.codeclan.capstoneproject.Campagna.models.accommodation;

import com.example.codeclan.capstoneproject.Campagna.models.bookings.NumberVerification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberVerificationTest {

    String phoneNumber1 = "077";
    String phoneNumber2 = "+4477";
    String phoneNumber3 = "77";

    @Test
    public void doesReturnTrue(){
        assertEquals(true, NumberVerification.startsWithPlus(phoneNumber1));
    }

    @Test
    public void doesReturnFalse(){
        assertEquals(false, NumberVerification.startsWithPlus(phoneNumber2));
    }

    @Test
    public void doesReturnFalseToo(){
        assertEquals(true, NumberVerification.startsWithPlus(phoneNumber3));
    }

    @Test
    public void doesAdd(){
        NumberVerification.addPlusFourFourToNumber(phoneNumber1);
        assertEquals("+4477", NumberVerification.addPlusFourFourToNumber(phoneNumber1));
    }

    @Test
    public void doesNotAdd(){
        assertEquals("+4477", NumberVerification.addPlusFourFourToNumber(phoneNumber2));
    }
    @Test
    public void againDoesAdd(){
        assertEquals("+4477", NumberVerification.addPlusFourFourToNumber(phoneNumber3));
    }
}
