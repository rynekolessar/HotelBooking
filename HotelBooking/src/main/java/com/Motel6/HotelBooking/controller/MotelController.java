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

import com.Motel6.HotelBooking.model.Motel;
import com.Motel6.HotelBooking.repository.MotelRepository;

@Controller
public class MotelController {

    @Autowired MotelRepository motelRepository;

    @GetMapping("/motels")
    public String getAll(Model md) {
        md.addAttribute("motels", motelRepository.getAll());
        return "motels";
    }
    
    

}