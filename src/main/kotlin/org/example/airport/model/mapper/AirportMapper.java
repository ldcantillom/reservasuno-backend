package org.example.airport.model.mapper;

import org.example.airport.model.dtos.AirportDto;
import org.example.airport.model.entities.Airport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = FlightMapper.class)
public interface AirportMapper {
    @Named("complete")
    @Mapping(source = "airport.flights", target = "flights", qualifiedByName = "listComplete")
    AirportDto toIdDto(Airport airport);

    @Named("withoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "airport.flights", target = "flights", qualifiedByName = "listWithoutId")
    AirportDto toDto(Airport airport);

    @Named("listComplete")
    @Mapping(source = "airport.flights", target = "flights", qualifiedByName = "listComplete")
    List<AirportDto> toListIdDto(List<Airport> airports);

    @Named("listWithoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "airport.flights", target = "flights", qualifiedByName = "listWithoutId")
    List<AirportDto> toListDto(List<Airport> airports);

    @Mapping(source = "airportDto.flights", target = "flights")
    Airport toEntity(AirportDto airportDto);

    @Mapping(source = "airportDto.flights", target = "flights")
    List<Airport> toListEntity(List<AirportDto> airportDtos);
}
