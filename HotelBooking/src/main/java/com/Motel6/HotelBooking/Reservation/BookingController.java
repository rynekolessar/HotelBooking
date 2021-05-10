<<<<<<< HEAD:HotelBooking/src/main/java/com/Motel6/HotelBooking/Reservation/BookingController.java
package com.Motel6.HotelBooking.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BookingInfo")
class BookingController {

    @Autowired
    Booking repository;

    @GetMapping
    public ResponseEntity<List<Booking>> getAll() {
        try {
            List<Booking> items = new ArrayList<Booking>();

            repository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Booking> getById(@PathVariable("id") Long id) {
        Booking existingItemOptional = repository.findById(id);

        if (existingItemOptional != null) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }

    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody Booking item) {
        try {
            Booking savedItem = repository.save(item.getId());
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Booking> update(@PathVariable("id") Long id, @RequestBody Booking item) {
        Booking existingItemOptional = repository.findById(id);
        
        if (existingItemOptional != null) {
            Booking existingItem = existingItemOptional.get();
            System.out.println("TODO for developer - update logic is unique to entity and must be implemented manually.");
            //existingItem.setSomeField(item.getSomeField());
            return new ResponseEntity<>(repository.save(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
=======
package com.Motel6.HotelBooking.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.Motel6.HotelBooking.model.Booking;
import com.Motel6.HotelBooking.repository.BookingRepository;

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
class BookingController {

    @Autowired
    BookingRepository repository;

    BookingController(BookingRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/booking")
    public ResponseEntity<List<Booking>> getAll() {
        try {
            List<Booking> items = new ArrayList<Booking>();
            repository.findAll().forEach(items::add);
            if (items.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("booking/{id}")
    public ResponseEntity<Booking> getById(@PathVariable("id") Long id) {
        Optional<Booking> existingItemOptional = repository.findById(id);

        if (existingItemOptional != null) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/booking")
    public ResponseEntity<Booking> newBooking(@RequestBody Booking newBooking) {
        try {
            Booking savedItem = repository.save(newBooking.getId());
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("booking/{id}")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking newBooking, @PathVariable Long id) {
        return repository.findById(id)
            .map(booking -> {
                booking.setCheckinDate(newBooking.getCheckinDate());
                booking.setCheckoutDate(newBooking.getCheckoutDate());
                booking.setCity(newBooking.getCity());
                booking.setGuestList(newBooking.getGuestList());
                booking.setGuestNum(newBooking.getGuestNum());
                return new ResponseEntity<Booking>(repository.save(booking.getBookingID()), HttpStatus.OK);
            })
            .orElseGet(() -> {
                newBooking.setBookingID(id);
                return new ResponseEntity<>(repository.save(newBooking.getBookingID()), HttpStatus.OK);
            });
    }

    @DeleteMapping("booking/{id}")
    public ResponseEntity<HttpStatus> deleteBooking(@PathVariable("id") Long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
>>>>>>> 643632a02cb0aa37a39f3c265037f2313ba1a8be:HotelBooking/src/main/java/com/Motel6/HotelBooking/controller/BookingController.java
}