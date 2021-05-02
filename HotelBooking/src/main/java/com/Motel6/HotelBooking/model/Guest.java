package com.Motel6.HotelBooking.model;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Guest {
    @Id public String id;

    public String firstName;
    public String lastName;

    public Guest() {}

    public Guest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
            "Guest[id=%s, firstName='%s', lastName='%s']",
            id, firstName, lastName);
    }
}