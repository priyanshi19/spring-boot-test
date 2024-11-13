package com.springBoot.Springboottutorial.Scopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final UserAuthenticationService authService;
    private final MessageService messageService;

    @Autowired
    public MessageController(UserAuthenticationService authService, MessageService messageService) {
        this.authService = authService;
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {
        // Get the logged-in user's username
        String sender = authService.getLoggedInUsername();
        authService.sendMessage(sender, "recipient@example.com", message);

        return "Message sent successfully";
    }
}
