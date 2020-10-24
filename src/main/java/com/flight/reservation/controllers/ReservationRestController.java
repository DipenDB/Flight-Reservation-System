package com.flight.reservation.controllers;

import com.flight.reservation.model.Reservation;
import com.flight.reservation.model.ReservationUpdate;
import com.flight.reservation.repository.ReservationRepository;
import com.flight.reservation.rest.ReservationUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationRestController {
    @Autowired
    ReservationRepository reservationRepository;


//    @RequestMapping("/reservations/{id}")
    @GetMapping("reservations/{id}")
    public Reservation findReservation(@PathVariable Long id) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        return reservation;

    }

    @PostMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdate request) {

        Reservation reservation = reservationRepository.findById(request.getId()).orElse(null);

        reservation.setNumberOfBags(request.getNumberOfBags());

        reservation.setCheckedIn(request.getCheckedIn());

        Reservation updateReservation = reservationRepository.save(reservation);

        return updateReservation;

    }






}
