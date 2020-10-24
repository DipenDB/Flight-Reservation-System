package com.flight.reservation.controllers;

import com.flight.reservation.model.Reservation;
import com.flight.reservation.rest.ReservationUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    ReservationUpdateRequest request;

    @GetMapping("checkIn")
    public String getAddFlight(){
        return "checkIn";
    }

    @RequestMapping("/startCheckin")
    public String startCheckin(@RequestParam("reservationId") Long reservationId, ModelMap model) {

        Reservation reservation = request.findReservation(reservationId);

        model.addAttribute("reservation", reservation);

        return "displayReservationDetail";

    }





}
