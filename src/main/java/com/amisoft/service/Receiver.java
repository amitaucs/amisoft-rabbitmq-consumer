package com.amisoft.service;

import com.amisoft.dto.UserEmail;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by amitdatta on 26/07/17.
 */

@Component
public class Receiver {

    public void receiveMessage(byte[] message) {

        String massageFromRabbitMQ = new String(message);
        System.out.println("Received  :" + massageFromRabbitMQ);
        if (StringUtils.isNotEmpty(massageFromRabbitMQ)) {
            Gson gson = new Gson();
            Optional<UserEmail> emailUser = Optional.of(gson.fromJson(massageFromRabbitMQ, UserEmail.class));
            if (emailUser.isPresent())
                System.out.println(emailUser.get().getUserEmailId());
        }

    }
}
