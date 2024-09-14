package org.example.airport.model.services;

import org.example.airport.model.entities.Airport;
import org.example.airport.model.entities.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    Flight saveFlight(Flight flight);
    Optional<Flight> findFlightById(Long id);
    List<Flight> findAllFlights();
    List<Flight> findAllFlightsByIds(List<Long> ids);
    List<Flight> findAllFlightsByAirport(Airport airport);
    List<Flight> findAllFlightsByDate(LocalDateTime date);
    List<Flight> findAllFlightsByAirportAndDate(Airport airport, LocalDateTime date);
    Optional<Flight> updateFlight(Long id, Flight flight);
    void deleteFlight(Flight flight);
}