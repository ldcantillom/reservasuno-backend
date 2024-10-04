package org.example.airport.model.mapper;

import lombok.AllArgsConstructor;
import org.example.airport.model.dtos.AirportDto;
import org.example.airport.model.entities.Airport;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AirportMapper {
    private FlightMapper flightMapper;
    public Airport toEntity(AirportDto airportDto) {
        Airport airport = new Airport();
        airport.setName(airportDto.name());
        airport.setCity(airportDto.city());
        airport.setCountry(airportDto.country());
        airport.setFlights(flightMapper.toListEntity(airportDto.flights()));
        return airport;
    }
    public AirportDto toDto(Airport airport) {
        AirportDto airportDto = new AirportDto(
        airport.getName(),
        airport.getCity(),
        airport.getCountry(),
        flightMapper.toListDto(airport.getFlights())
        );
        return airportDto;
    }

}
