package org.example.airport.model.services;

import org.example.airport.model.entities.Airport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AirportService {
    Airport saveAirport(Airport airport);
    Optional<Airport> getById(Long id);
    List<Airport> getAllAirports();
    List<Airport> getAllAirportsByIds(List<Long> ids);
    List<Airport> getAllAirportsByName(String airportName);
    List<Airport> getAllAirportsByCity(String city);
    List<Airport> getAllAirportByCountry(String country);
    Optional<Airport> updateAirport(Long id,Airport airport);
    void deleteAirport(Long id);
}