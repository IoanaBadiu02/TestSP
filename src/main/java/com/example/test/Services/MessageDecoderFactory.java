package com.example.test.Services;

public class MessageDecoderFactory {
    public static MessageDecoder createDecoder(String house) {
        if ("Atreides".equalsIgnoreCase(house)) {
            return new AtreidesDecoder();
        } else if ("Harkonnen".equalsIgnoreCase(house)) {
            return new HarkonnenDecoder();
        } else {
            throw new IllegalArgumentException("Nu exista casa: " + house);
        }
    }
}