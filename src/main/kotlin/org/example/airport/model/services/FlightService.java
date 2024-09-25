package org.example.airport.model.services;

import org.example.airport.model.entities.Airport;
import org.example.airport.model.entities.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    Flight saveFlight(Flight flight);
    Optional<Flight> getFlightById(Long id);
    List<Flight> getAllFlights();
    List<Flight> getAllFlightsByIds(List<Long> ids);
    List<Flight> getAllFlightsByAirport(Airport airport);
    List<Flight> getAllFlightsByDate(LocalDateTime date);
    List<Flight> getAllFlightsByAirportAndDate(Airport airport, LocalDateTime date);
    Optional<Flight> updateFlight(Long id, Flight flight);
    void deleteFlight(Long id);
}