package org.example.airport.model.services;

import org.example.airport.model.entities.Airlane;
import org.example.airport.model.entities.Airport;

import java.util.List;
import java.util.Optional;

public interface AirlaneService {
    Airlane saveAirlane(Airlane airlane);
    Optional<Airlane> findAirlaneById(Long id);
    List<Airlane> findAllAirlanes();
    List<Airlane> findAllAirlanesByIds(List<Long> ids);
    List<Airlane> findAllAirlanesByName(String name);
    List<Airlane> findAllAirlanesByCountry(String country);
    Optional<Airport> updateAirlane(Long id, Airlane airlane);
    void deleteAirlane(Long id);
}