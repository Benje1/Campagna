package com.example.codeclan.capstoneproject.Campagna.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class TwilioMessagingService {
    public void send(String ACCOUNT_SID, String AUTH_TOKEN, String phoneNumber, String messageBody) {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                            new com.twilio.type.PhoneNumber(phoneNumber),
                            "MG27a544a4ae6d327987476c605f0e9a0c",
                            messageBody)
                    .create();
            System.out.println(message.getSid());
    }
}