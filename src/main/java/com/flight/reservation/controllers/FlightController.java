package com.flight.reservation.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.flight.reservation.model.Flight;
import com.flight.reservation.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    FlightRepository flightRepository;
//----------------------------------------------------------------------------------
    @GetMapping("addFlight")
    public String getAddFlight(){
        return "addFlight";
    }
    @PostMapping("addFlightData")
    public String addFlight(@ModelAttribute Flight flight){
        flightRepository.save(flight);
        return "addFlight";
    }
//-----------------------------------------------------------------------------------


    @GetMapping("searchFlight")
    public String getSearchFlight(){
        return "searchFlight";
    }

    @PostMapping("searchFlights")
    public String findFlight(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("date") @JsonFormat(pattern = "yyyy-MM-dd") String date, ModelMap model) {
        List<Flight> Flights = flightRepository.findFlights(from,to,date);

        model.addAttribute("flights", Flights);

        return "displayFlight";
    }




//    @GetMapping("displayFlight")
//    public String getDisplayFlight(){
//        return "displayFlight";
//    }

}
