package org.example.airport.model.mapper;

import org.example.airport.model.dtos.FlightDto;
import org.example.airport.model.entities.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    Flight toEntity(FlightDto flightDto);
    FlightDto toDto(Flight flight);
    List<Flight> toListEntity(List<FlightDto> flightsDto);
    List<FlightDto> toListDto(List<Flight> flights);
}
