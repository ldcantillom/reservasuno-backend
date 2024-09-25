package org.example.airport.model.services;

import org.example.airport.model.entities.Airport;
import org.example.airport.model.entities.Scale;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ScaleService {
    Scale save(Scale scale);
    Optional<Scale> findById(Long id);
    List<Scale> findAllScales();
    List<Scale> findAllScalesByName(String name);
    List<Scale> findAllScalesByAirportOrigin(Airport airport);
    Optional<Scale> updateScale(Long id,Scale scale);
    void deleteScale(Long id);
}
