package org.example.airport.model.services;

import org.example.airport.model.dtos.AirportDto;
import org.example.airport.model.entities.Airport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AirportService {
    AirportDto save(AirportDto airport);
    Optional<AirportDto> findById(int id);
    Optional<AirportDto> update(int id, AirportDto airport);
    List<AirportDto> findAll();
    List<AirportDto> findByName(String name);
    void deleteById(int id);
}