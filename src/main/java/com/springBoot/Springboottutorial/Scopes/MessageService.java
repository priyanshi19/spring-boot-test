package com.springBoot.Springboottutorial.Scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class MessageService {

    private String sender;

    public MessageService() {
        System.out.println("MessageService Object created");
    }

    private String recipient;
    private String message;

    public void sendMessage(String sender, String recipient, String message) {
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;

        // Send the message (implementation not shown)
        System.out.println("Message sent: " + message);
    }

    // Getter and setter methods
}
