package com.flight.reservation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.flight.reservation.model.common.AbstractEntity;

import javax.persistence.Entity;

@Entity
public class Flight extends AbstractEntity {

    private String flightNumber;
    private String operatingAirlines;
    private String departureCity;
    private String arrivalCity;

    @JsonFormat(pattern="yyyy-MM-dd")   //,shape = Shape.STRING)
    private String dateOfDeparture;

    @JsonFormat(pattern="yyyy-MM-dd h:mm a")  //,shape = Shape.STRING)
    private String estimatedDepartureTime;


    public Flight() {
    }

    public Flight(String flightNumber, String operatingAirlines, String departureCity, String arrivalCity, String dateOfDeparture, String estimatedDepartureTime) {
        this.flightNumber = flightNumber;
        this.operatingAirlines = operatingAirlines;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.dateOfDeparture = dateOfDeparture;
        this.estimatedDepartureTime = estimatedDepartureTime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", operatingAirlines='" + operatingAirlines + '\'' +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", dateOfDeparture='" + dateOfDeparture + '\'' +
                ", estimatedDepartureTime='" + estimatedDepartureTime + '\'' +
                '}';
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOperatingAirlines() {
        return operatingAirlines;
    }

    public void setOperatingAirlines(String operatingAirlines) {
        this.operatingAirlines = operatingAirlines;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(String dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public String getEstimatedDepartureTime() {
        return estimatedDepartureTime;
    }

    public void setEstimatedDepartureTime(String estimatedDepartureTime) {
        this.estimatedDepartureTime = estimatedDepartureTime;
    }
}
