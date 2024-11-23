package org.example.airport.model.dtos;

import java.time.LocalDateTime;
import java.util.List;

public record FlightIdDto(Long id,
                          AirlaneDto airlane,
                          AirportDto airportOrigin,
                          AirportDto airportDestination,
                          LocalDateTime departureTime,
                          LocalDateTime arrivalTime,
                          int capacity,
                          List<ReserveDto> reserves
                       ) {
}
