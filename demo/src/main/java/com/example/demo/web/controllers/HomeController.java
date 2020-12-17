package com.example.demo.web.controllers;

import com.example.demo.beans.ListItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public ResponseEntity<?> hi(){
        return new ResponseEntity<>("hi world", HttpStatus.OK);

    }
}
