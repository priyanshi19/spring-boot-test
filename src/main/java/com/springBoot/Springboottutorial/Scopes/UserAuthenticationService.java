package com.springBoot.Springboottutorial.Scopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserAuthenticationService {

    @Autowired
    MessageService messageService;

    public UserAuthenticationService() {
        System.out.println("UserAuthenticationService object is created");
    }

    private String loggedInUsername;

    public void login(String username) {
        loggedInUsername = username;
    }

    public String getLoggedInUsername() {
        return loggedInUsername;
    }

    public void logout() {
        loggedInUsername = null;
    }

    public void sendMessage(String sender, String mail, String message) {
        messageService.sendMessage(sender,mail,message);
    }
}
