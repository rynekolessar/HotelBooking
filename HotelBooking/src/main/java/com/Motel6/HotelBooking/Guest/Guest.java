package com.Motel6.HotelBooking.Guest;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class Guest {

    @Id
    private Long GuestID;
    private String name;

    public Guest() {
    }

    public Long getId() {
        return GuestID;
    }

    public void setId(Long id) {
        this.GuestID = id;
    }
}