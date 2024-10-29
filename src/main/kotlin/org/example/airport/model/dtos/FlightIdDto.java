package org.example.airport.model.dtos;

import java.time.LocalDateTime;
import java.util.List;

public record FlightIdDto(Long id,
                          AirlaneDto airlane,
                          AirportDto airport_origin,
                          AirportDto airport_destination,
                          LocalDateTime departure_time,
                          LocalDateTime arrival_time,
                          int capacity,
                          List<ReserveDto> reserves
                       ) {
}
