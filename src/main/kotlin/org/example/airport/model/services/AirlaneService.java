package org.example.airport.model.services;

import org.example.airport.model.entities.Airlane;
import org.example.airport.model.entities.Airport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AirlaneService {
    Airlane saveAirlane(Airlane airlane);
    Optional<Airlane> getAirlaneById(Long id);
    List<Airlane> getAllAirlanes();
    List<Airlane> getAllAirlanesByIds(List<Long> ids);
    List<Airlane> getAllAirlanesByName(String name);
    List<Airlane> getAllAirlanesByCountry(String country);
    Optional<Airlane> updateAirlane(Long id, Airlane airlane);
    void deleteAirlane(Long id);
}