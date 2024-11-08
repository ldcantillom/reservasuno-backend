package org.example.airport.model.mapper;

import org.example.airport.model.dtos.PassengerDto;
import org.example.airport.model.dtos.PassengerIdDto;
import org.example.airport.model.entities.Passenger;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassengerMapper {
    PassengerMapper passengerMapperMapper = Mappers.getMapper(PassengerMapper.class);
    Passenger toEntity(PassengerDto passengerDto);
    PassengerDto toDto(Passenger passenger);
    PassengerIdDto toIdDto(Passenger passenger);
    List<PassengerDto> toListDto(List<Passenger> passengers);
    List<PassengerIdDto> toListIdDto(List<Passenger> passengers);
    List<Passenger> toListEntity(List<PassengerDto> passengersDto);
}
