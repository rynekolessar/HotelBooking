package com.Motel6.HotelBooking.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Motel6.HotelBooking.model.Membership;

@Repository
public interface MembershipRepository extends MongoRepository<Membership, String> {
    public Membership findByGuestId(String guestId);
    public List<Membership> findByLevel(String level);
}

