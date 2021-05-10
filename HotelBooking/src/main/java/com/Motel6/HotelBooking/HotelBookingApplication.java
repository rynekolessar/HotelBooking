package com.Motel6.HotelBooking;

<<<<<<< HEAD
=======
import com.Motel6.HotelBooking.model.Guest;
import com.Motel6.HotelBooking.repository.GuestRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
>>>>>>> 643632a02cb0aa37a39f3c265037f2313ba1a8be
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class HotelBookingApplication {
<<<<<<< HEAD
=======
	// @Autowired
	// BookingRepository bookingRepository;

	@Autowired
	GuestRepository guestRepository;
>>>>>>> 643632a02cb0aa37a39f3c265037f2313ba1a8be

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingApplication.class, args);
	}

<<<<<<< HEAD
=======
	private static final Logger logger = LoggerFactory.getLogger(HotelBookingApplication.class);

	@Bean
	public CommandLineRunner demo(GuestRepository repository) {
		return (args) -> {
			logger.info("Deleting all records...");
			repository.deleteAll();

			logger.info("Adding sample data...");
			repository.save(new Guest("Ryne", "Kolesssar"));
			repository.save(new Guest("Johnny", "Appleseed"));
			repository.save(new Guest("Joe", "Biden"));

			logger.info("Listing Sample Data...");
			logger.info("----------------------");
			repository.findAll().forEach(System.out::println);

			logger.info("Guests found with findByLastName('Biden')");
			logger.info("-----------------------------------------");
			repository.findByLastName("Biden").forEach(System.out::println);
		};
	}
>>>>>>> 643632a02cb0aa37a39f3c265037f2313ba1a8be
}
