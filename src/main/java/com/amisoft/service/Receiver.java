package com.amisoft.service;

import org.springframework.stereotype.Component;

/**
 * Created by amitdatta on 26/07/17.
 */

@Component
public class Receiver {

    public void receiveMessage(byte[] message) {
        System.out.println("Received  :" + new String(message));
    }
}
