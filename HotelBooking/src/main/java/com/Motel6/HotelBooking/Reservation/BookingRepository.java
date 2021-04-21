package com.Motel6.HotelBooking.Reservation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long>{

    Booking findById(long id);
    List<Booking> findAll();
    void deleteById(long id);
    Booking save(long id);
}