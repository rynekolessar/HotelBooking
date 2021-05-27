package com.Motel6.HotelBooking.model;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Room {
    @Id String id;

    public int roomcode;
    public String roomType;
    public float cost;

    public Room(String roomType, int roomcode, float cost){
        this.roomType = roomType;
        this.roomcode = roomcode;
        this.cost = cost;
    }
}
