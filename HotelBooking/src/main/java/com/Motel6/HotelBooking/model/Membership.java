package com.Motel6.HotelBooking.model;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Membership {
    @Id public String id;

    public String guestId;
    public String level;

    public Membership() {}

    public Membership(String guestId, String level) {
        this.guestId = guestId;
        this.level = level;
    }
}