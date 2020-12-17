package com.example.demo.web.controllers;

import com.example.demo.beans.Item;
import com.example.demo.beans.ListItem;
import com.example.demo.exception.InvalidEntityException;
import com.example.demo.services.SportsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("sports")
public class SportsController {
    private final SportsServiceImpl sportsServiceImpl;

    @PostMapping
    public  void addItem(@RequestBody Item item) throws InvalidEntityException {
        sportsServiceImpl.addItem(item);
    }

    @PutMapping
    public ResponseEntity<?> updateItem(@RequestBody Item item){

        try {
            sportsServiceImpl.updateItem(item);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (InvalidEntityException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneItem(@PathVariable long id){
        try {
            return new ResponseEntity<>(sportsServiceImpl.getSingleItem(id),HttpStatus.OK);
        } catch (InvalidEntityException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping
    public ResponseEntity<?> getAllItems(){
        ListItem listItem = new ListItem(sportsServiceImpl.getAllItems());
        return new ResponseEntity<>(listItem,HttpStatus.OK);

    }
    @GetMapping("/count")
    public ResponseEntity<?> getItemsCount(){
        return new ResponseEntity<>(sportsServiceImpl.getItemsCount(),HttpStatus.OK);
    }

}
