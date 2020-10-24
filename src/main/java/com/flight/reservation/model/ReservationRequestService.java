package com.flight.reservation.model;

import com.flight.reservation.repository.FlightRepository;
import com.flight.reservation.repository.PassengerRepository;
import com.flight.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationRequestService {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;


    public Reservation bookFlight(ReservationRequest reservationRequest){
        try {

            Flight flight = flightRepository.findById(reservationRequest.getFlightId()).get();

            Passenger passenger = new Passenger();
            passenger.setFirstName(reservationRequest.getpFirstName());
            passenger.setMiddleName(reservationRequest.getpMiddleName());
            passenger.setLastName(reservationRequest.getpLastName());
            passenger.setEmail(reservationRequest.getpEmail());
            passenger.setPhone(reservationRequest.getpPhone());
            Passenger savedPassenger = passengerRepository.save(passenger);

            Reservation reservation = new Reservation();
            reservation.setCheckedIn(false);
            reservation.setPassenger(savedPassenger);
            reservation.setFlight(flight);
            Reservation savedReservation = reservationRepository.save(reservation);

            return savedReservation;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



}
