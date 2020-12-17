package com.example.demo.web.controllers;

import com.example.demo.beans.Item;
import com.example.demo.beans.ListItem;
import com.example.demo.exception.InvalidEntityException;
import com.example.demo.services.ElectricityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("electricity")
public class ElectricityController {
    private final ElectricityServiceImpl electricityServiceImpl;

    @PostMapping
    public  void addItem(@RequestBody Item item) throws InvalidEntityException {
        electricityServiceImpl.addItem(item);
    }

    @PutMapping
    public ResponseEntity<?> updateItem(@RequestBody Item item){

        try {
            electricityServiceImpl.updateItem(item);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (InvalidEntityException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneItem(@PathVariable long id){
        try {
            return new ResponseEntity<>(electricityServiceImpl.getSingleItem(id),HttpStatus.OK);
        } catch (InvalidEntityException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping
    public ResponseEntity<?> getAllItems(){
        ListItem listItem = new ListItem(electricityServiceImpl.getAllItems());
        return new ResponseEntity<>(listItem,HttpStatus.OK);

    }
    @GetMapping("/count")
    public ResponseEntity<?> getItemsCount(){
        return new ResponseEntity<>(electricityServiceImpl.getItemsCount(),HttpStatus.OK);
    }

}
