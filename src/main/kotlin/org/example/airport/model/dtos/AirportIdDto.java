package org.example.airport.model.dtos;

import java.util.List;

public record AirportIdDto(String name,
                           String city,
                           String country,
                           List<FlightDto> flights) {
}
