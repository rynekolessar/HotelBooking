<<<<<<< HEAD:HotelBooking/src/main/java/com/Motel6/HotelBooking/Reservation/Booking.java
package com.Motel6.HotelBooking.Reservation;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingID;
    private String city;
    private Date checkinDate;
    private Date checkoutDate;
    private int guestNum;
    private List<Guest> guestList;

    private BookingRepository repository;

    public long getId(){
        return bookingID;
    }
    public List<Booking> findAll(){
        return repository.findAll();
    };

    public Booking findById(long bookingID){
        return repository.findById(bookingID);
    };
 
    public void deleteById(long bookingID){
        repository.deleteById(bookingID);
    };

    public Booking save(long bookingID){
        return repository.save(bookingID);
    };

    public Booking get() {
        return this;
    }

    public void addGuest(Guest newGuest){
        guestList.add(newGuest);
    }

    public void removeGuest(Guest existingGuest){
        guestList.remove(existingGuest);
    }

=======
package com.Motel6.HotelBooking.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.Motel6.HotelBooking.repository.BookingRepository;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingID;
    private String city;
    private Date checkinDate;
    private Date checkoutDate;
    private int guestNum;
    private List<Guest> guestList;

    private BookingRepository repository;

    public long getId(){
        return bookingID;
    }
    public List<Booking> findAll() {
        return repository.findAll();
    };

    public Booking findById(long bookingID) {
        return repository.findById(bookingID);
    };
 
    public void deleteById(long bookingID) {
        repository.deleteById(bookingID);
    };

    public Booking save(long bookingID) {
        return repository.save(bookingID);
    };

    public Booking get() {
        return this;
    }

    public void addGuest(Guest newGuest) {
        guestList.add(newGuest);
    }

    public void removeGuest(Guest existingGuest) {
        guestList.remove(existingGuest);
    }

>>>>>>> 643632a02cb0aa37a39f3c265037f2313ba1a8be:HotelBooking/src/main/java/com/Motel6/HotelBooking/model/Booking.java
}