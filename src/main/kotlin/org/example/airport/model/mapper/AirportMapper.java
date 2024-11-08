package org.example.airport.model.mapper;

import org.example.airport.model.dtos.AirportDto;
import org.example.airport.model.entities.Airport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AirportMapper {
    AirportMapper INSTANCE = Mappers.getMapper(AirportMapper.class);

    AirportDto toDto(Airport airport);
    Airport toEntity(AirportDto airportDto);
}
