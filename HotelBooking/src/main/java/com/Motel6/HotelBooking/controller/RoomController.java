package com.Motel6.HotelBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.Motel6.HotelBooking.model.Room;
import com.Motel6.HotelBooking.repository.RoomRepository;

@Controller
public class RoomController {

    // @Autowired
    RoomRepository roomRepository;

    @GetMapping("/rooms")
    public String getAll(Model md) {
        md.addAttribute("rooms", roomRepository.getAll());
        return "rooms";
    }

}
