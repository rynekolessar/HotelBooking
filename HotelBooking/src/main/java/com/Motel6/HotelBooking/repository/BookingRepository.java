package com.Motel6.HotelBooking.repository;

import java.util.List;

import com.Motel6.HotelBooking.model.Booking;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends MongoRepository<Booking, Long>{
    public Booking findById(long id);
    public List<Booking> findAll();
    public void deleteById(long id);
    public Booking save(long id);
}