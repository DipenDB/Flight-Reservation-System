package com.flight.reservation.controllers;

import com.flight.reservation.model.Flight;
import com.flight.reservation.model.ReservationRequest;
import com.flight.reservation.model.ReservationRequestService;
import com.flight.reservation.repository.FlightRepository;
import com.flight.reservation.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("reservation")
public class ReservationController {
    @Autowired
    EmailUtil emailUtil;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    ReservationRequestService reservationRequestService;

    @GetMapping("{id}")
    public String showCompleteReservation(@PathVariable("id") Long id, ModelMap modelMap){
        Flight flight = flightRepository.findById(id).get();
        modelMap.addAttribute("flight",flight);
        return "completeReservation";
    }

    @PostMapping("complete-reservation")
    public String completeReservation(@ModelAttribute ReservationRequest reservationRequest, ModelMap modelMap){
        reservationRequestService.bookFlight(reservationRequest);

        modelMap.addAttribute("msg","Reservation created successfully");

//        emailUtil.sendMail(reservationRequest.getpEmail(),"Reservation Complete","Reservation complete");

        return "reservationConfirmation";
        }






}
