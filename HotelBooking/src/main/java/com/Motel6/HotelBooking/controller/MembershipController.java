package com.Motel6.HotelBooking.controller;

import java.util.List;
import java.util.Optional;

import com.Motel6.HotelBooking.repository.MembershipRepository;
import com.Motel6.HotelBooking.model.Membership;

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
public class MembershipController {
    @Autowired
    MembershipRepository repository;

    MembershipController(MembershipRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/memberships")
    public ResponseEntity<List<Membership>> getAll() {
        try {
            return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/memberships/{id}")
    public ResponseEntity<Membership> getById(@PathVariable("id") String id) {
        Optional<Membership> existingItemOptional = repository.findById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<Membership>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Membership>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/memberships")
    public ResponseEntity<Membership> newMembership(@RequestBody Membership newMembership) {
        try {
            Membership savedItem = repository.save(newMembership);
            return new ResponseEntity<Membership>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/memberships/{id}")
    public ResponseEntity<Membership> replaceMembership(@RequestBody Membership newMembership, @PathVariable String id) {
        return repository.findById(id)
            .map(Membership -> {
                Membership.setGuestId(newMembership.getGuestId());
                Membership.setLevel(newMembership.getLevel());
                return new ResponseEntity<>(repository.save(Membership), HttpStatus.OK);
            })
            .orElseGet(() -> {
                newMembership.setId(id);
                return new ResponseEntity<>(repository.save(newMembership), HttpStatus.OK);
            });
    }

    @DeleteMapping("/memberships/{id}")
    public ResponseEntity<HttpStatus> deleteMembership(@PathVariable("id") String id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
