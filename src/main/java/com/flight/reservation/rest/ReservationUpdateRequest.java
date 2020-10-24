package com.flight.reservation.rest;

import com.flight.reservation.model.Reservation;

public interface ReservationUpdateRequest {

    public Reservation findReservation(Long id);

    public Reservation updateReservation(ReservationUpdateRequest request);

}
