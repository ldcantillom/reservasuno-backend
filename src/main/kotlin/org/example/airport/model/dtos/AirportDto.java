package org.example.airport.model.dtos;

import java.util.List;

public record AirportDto(
        Long id,
        String name,
        String city,
        String country,
        List<FlightDto> flights) {
}
