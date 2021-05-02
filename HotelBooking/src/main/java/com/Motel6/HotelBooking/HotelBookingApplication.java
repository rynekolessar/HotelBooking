package com.Motel6.HotelBooking;

import com.Motel6.HotelBooking.model.Guest;
import com.Motel6.HotelBooking.repository.BookingRepository;
import com.Motel6.HotelBooking.repository.GuestRepository;

import org.h2.command.CommandInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelBookingApplication implements CommandLineRunner{

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	GuestRepository guestRepository;

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		deleteAll();
		addSampleData();
		listAll();
		findByLastName();
	}

	public void deleteAll() {
		System.out.println("Deleting all records...");
		guestRepository.deleteAll();
	}

	public void addSampleData() {
		System.out.print("Adding sample data");
		guestRepository.save(new Guest("Ryne", "Kolesssar"));
		guestRepository.save(new Guest("Johnny", "Appleseed"));
		guestRepository.save(new Guest("Joe", "Biden"));
	}

	public void listAll() {
		System.out.println("Listing Sample Data");
		guestRepository.findAll().forEach(g -> System.out.println(g));
	}

	public void findByLastName() {
		System.out.println("Finding By Last Name");
		guestRepository.findByLastName("lastName").forEach(g -> System.out.println(g));
	}
}
