package com.Motel6.HotelBooking.Reservation;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class Guest {

    @Id
    private String name;

    public Guest() {
    }
}