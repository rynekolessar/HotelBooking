package com.Motel6.HotelBooking;

import com.Motel6.HotelBooking.model.Guest;
import com.Motel6.HotelBooking.model.Role;
import com.Motel6.HotelBooking.repository.GuestRepository;
import com.Motel6.HotelBooking.repository.RoleRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class HotelBookingApplication {
	// @Autowired
	// BookingRepository bookingRepository;

	@Autowired
	GuestRepository guestRepository;

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingApplication.class, args);
	}

	private static final Logger logger = LoggerFactory.getLogger(HotelBookingApplication.class);

	// @Bean
	// public CommandLineRunner demo(GuestRepository repository) {
	// 	return (args) -> {
	// 		logger.info("Deleting all records...");
	// 		repository.deleteAll();

	// 		logger.info("Adding sample data...");
	// 		repository.save(new Guest("Ryne", "Kolesssar"));
	// 		repository.save(new Guest("Johnny", "Appleseed"));
	// 		repository.save(new Guest("Joe", "Biden"));

	// 		logger.info("Listing Sample Data...");
	// 		logger.info("----------------------");
	// 		repository.findAll().forEach(System.out::println);

	// 		logger.info("Guests found with findByLastName('Biden')");
	// 		logger.info("-----------------------------------------");
	// 		repository.findByLastName("Biden").forEach(System.out::println);
	// 	};
	// }

	@Bean
	CommandLineRunner init(RoleRepository roleRepository) {
		return args -> {
			Role adminRole = roleRepository.findByRole("ADMIN");
			if (adminRole == null) {
				Role newAdminRole = new Role();
				newAdminRole.setRole("ADMIN");
				roleRepository.save(newAdminRole);
			}

			Role userRole = roleRepository.findByRole("USER");
			if (userRole == null) {
				Role newUserRole = new Role();
				newUserRole.setRole("USER");
				roleRepository.save(newUserRole);
			}
		};
	}

}
