package com.Motel6.HotelBooking.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Motel6.HotelBooking.model.Guest;

@Repository
public interface GuestRepository extends MongoRepository<Guest, String> {
    public Guest findByFirstName(String firstName);
    public List<Guest> findByLastName(String lastName);
    
}
