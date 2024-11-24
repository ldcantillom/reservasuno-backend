package org.example.airport.model.services;

import org.example.airport.model.dtos.FlightDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    FlightDto save(FlightDto flight);
    Optional<FlightDto> findById(int id);
    Optional<FlightDto> update(int id, FlightDto flight);
    List<FlightDto> findAll();
    List<FlightDto> findByDate(LocalDateTime date);
    void deleteFlight(int id);
}