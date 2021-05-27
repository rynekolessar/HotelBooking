package com.Motel6.HotelBooking.model;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Motel {
    @Id String id;

    public String city;
    public int motelCode;

    public Motel(String city, int motelCode) {
        this.city = city;
        this.motelCode = motelCode;
    }
}
