package com.Motel6.HotelBooking.repository;

import com.Motel6.HotelBooking.model.Role;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByRole(String role);
}
