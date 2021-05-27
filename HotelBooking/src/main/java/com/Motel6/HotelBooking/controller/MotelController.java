package com.Motel6.HotelBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Motel6.HotelBooking.repository.MotelRepository;

@Controller
public class MotelController {

    // @Autowired 
    MotelRepository motelRepository;

    @GetMapping("/motels")
    public String getAll(Model md) {
        md.addAttribute("motels", motelRepository.getAll());
        return "motels";
    }
    
}
