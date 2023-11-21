package com.example.test;

import com.example.test.Services.MessageDecoder;
import com.example.test.Services.MessageDecoderFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        List<Message> messages = new ArrayList<>();

        try {
            messages = new ObjectMapper().readValue(
                    new URL("file:src/messages.json"),
                    new TypeReference<>() {
                    }
            );
        } catch (Exception e) {
            System.err.print(e);
        }

        System.out.println("Mesajele initiale:\n");
        for (Message message : messages) {
            message.print();
        }

        System.out.println("Mesajele decodate:\n");
        for (Message message : messages) {
            MessageDecoder decoder = MessageDecoderFactory.createDecoder(message.getHouse());
            String decodedMessage = decoder.decode(message.getMessage());
            message.setMessage(decodedMessage);
            message.print();
        }

    }
}