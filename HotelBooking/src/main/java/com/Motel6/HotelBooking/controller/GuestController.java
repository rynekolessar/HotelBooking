package com.Motel6.HotelBooking.controller;

import java.util.List;
import java.util.Optional;

import com.Motel6.HotelBooking.repository.GuestRepository;
import com.Motel6.HotelBooking.model.Guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GuestController {

    @Autowired
    GuestRepository repository;

    GuestController(GuestRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/guests")
    public ResponseEntity<List<Guest>> getAll() {
        try {
            return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }

    @GetMapping("/guests/{id}")
    public ResponseEntity<Guest> getById(@PathVariable("id") String id) {
        Optional<Guest> existingItemOptional = repository.findById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<Guest>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Guest>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guests")
    public ResponseEntity<Guest> newGuest(@RequestBody Guest newGuest) {
        try {
            Guest savedItem = repository.save(newGuest);
            return new ResponseEntity<Guest>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/guests/{id}")
    public ResponseEntity<Guest> replaceGuest(@RequestBody Guest newGuest, @PathVariable String id) {
        return repository.findById(id)
            .map(guest -> {
                guest.setFirstName(newGuest.getFirstName());
                guest.setLastName(newGuest.getLastName());
                return new ResponseEntity<>(repository.save(guest), HttpStatus.OK);
            })
            .orElseGet(() -> {
                newGuest.setId(id);
                return new ResponseEntity<>(repository.save(newGuest), HttpStatus.OK);
            });
    }

    @DeleteMapping("/guests/{id}")
    public ResponseEntity<HttpStatus> deleteGuest(@PathVariable("id") String id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}