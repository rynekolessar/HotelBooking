package com.Motel6.HotelBooking.BookingInfo;

import java.util.Date;

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
}