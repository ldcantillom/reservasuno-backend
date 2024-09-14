package org.example.airport.model.services;

import org.example.airport.model.entities.Airport;
import java.util.List;
import java.util.Optional;

public interface AirportService {
    Airport saveAirport(Airport airport);
    Optional<Airport> findById(Long id);
    List<Airport> findAllAirports();
    List<Airport> findAllAirportsByIds(List<Long> ids);
    List<Airport> findAllAirportsByName(String airportName);
    List<Airport> findAllAirportsByCity(String city);
    List<Airport> findAllAirportByCountry(String country);
    Optional<Airport> updateAirport(Long id,Airport airport);
    void deleteAirport(Long id);
}