package com.example.codeclan.capstoneproject.Campagna.models.bookings;

public class NumberVerification {

    public static boolean startsWithPlus(String phoneNumber){
        char first = phoneNumber.charAt(0);
        if(first != '+'){
            return true;
        } else {
            return false;
        }
    }

    public static boolean startsWithZero(String phoneNumber){
        char first = phoneNumber.charAt(0);
        if(first == '0'){
            return true;
        } else {
            return false;
        }
    }

    public static String addPlusFourFourToNumber(String phoneNumber){
        if(startsWithZero(phoneNumber)){
            StringBuffer number = new StringBuffer(phoneNumber);
            number.replace(0, 1, "+44");
            return number.toString();
        } else  if (startsWithPlus(phoneNumber)){
            StringBuffer number = new StringBuffer(phoneNumber);
            number.replace(0, 0, "+44");
            return number.toString();
        } else {
            return phoneNumber;
        }
    }
}
