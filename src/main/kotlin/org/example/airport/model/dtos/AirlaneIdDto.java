package org.example.airport.model.dtos;
import java.util.List;


public record AirlaneIdDto(Long id,
                           String name,
                           String airlane_code,
                           String origin_country,
                           List<FlightDto> flights) {
}
