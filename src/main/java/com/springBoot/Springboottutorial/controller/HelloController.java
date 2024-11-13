package com.springBoot.Springboottutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
public class HelloController {
    @Value("${welcome-msg}")
    String welcome;

    @GetMapping(value = "/")
    public String helloWorld(){
        return welcome;
    }

    @GetMapping(value="/getNameTokenValue/{id}")
    public ResponseEntity getNameTokenValue(@RequestHeader String token, @PathVariable String id,@RequestParam String name){
        String message="Get the messages here!!";
        System.out.println("id: "+id);
        System.out.println("token: "+token);
        System.out.println("name: "+name);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
    }

}
