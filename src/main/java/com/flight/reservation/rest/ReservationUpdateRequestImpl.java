package com.flight.reservation.rest;

import com.flight.reservation.model.Reservation;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReservationUpdateRequestImpl implements ReservationUpdateRequest{


    @Override
    public Reservation findReservation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.getForObject("http://localhost:8080/reservations/" + id, Reservation.class);

        return reservation;
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest updateRequest) {
        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.postForObject(url, request, responseType)
        Reservation reservation = restTemplate.postForObject("http://localhost:8080/reservations/", updateRequest, Reservation.class);
        return reservation;
    }
}
