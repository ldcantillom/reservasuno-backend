package org.example.airport.model.dtos;

import org.example.airport.model.entities.Reserve;

import java.time.LocalDateTime;
import java.util.List;

public record FlightDto(AirlaneDto airlane,
                        AirportDto airport_origin,
                        AirportDto airport_destination,
                        LocalDateTime departure_time,
                        LocalDateTime arrival_time,
                        int capacity,
                        List<ReserveDto> reserves
                       ) {
}
