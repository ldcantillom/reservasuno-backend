package org.example.airport.model.mapper;

import lombok.AllArgsConstructor;
import org.example.airport.model.dtos.PassengerDto;
import org.example.airport.model.dtos.PassengerIdDto;
import org.example.airport.model.entities.Passenger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class PassengerMapper {
    private ReserveMapper reserveMapper;
    public Passenger toEntity(PassengerDto passengerDto){
        Passenger passenger = new Passenger();
        passenger.setFirstName(passenger.getFirstName());
        passenger.setLastName(passenger.getLastName());
        passenger.setAddress(passenger.getAddress());
        passenger.setCell(passenger.getCell());
        passenger.setEmail(passenger.getEmail());
        passenger.setIdentificationNumber(passenger.getIdentificationNumber());
        passenger.setReserve(passenger.getReserve());
        return passenger;
    }
    public PassengerDto toDto(Passenger passenger){
        PassengerDto passangerDto = new PassengerDto(
                passenger.getFirstName(),
                passenger.getLastName(),
                passenger.getAddress(),
                passenger.getCell(),
                passenger.getEmail(),
                passenger.getIdentificationNumber(),
                reserveMapper.toDto(passenger.getReserve())
        );
                return passangerDto;
    }
    public PassengerIdDto toIdDto(Passenger passenger){
        PassengerIdDto passangerIdDto = new PassengerIdDto(
                passenger.getId(),
                passenger.getFirstName(),
                passenger.getLastName(),
                passenger.getAddress(),
                passenger.getCell(),
                passenger.getEmail(),
                passenger.getIdentificationNumber(),
                reserveMapper.toDto(passenger.getReserve())
        );
        return passangerIdDto;
    }
    public List<PassengerDto> toListDto(List<Passenger> passengers){
        List<PassengerDto> passengerDtos = new ArrayList<>();
        for(Passenger passenger : passengers){
            passengerDtos.add(toDto(passenger));
        }
        return passengerDtos;
    }
    public List<PassengerIdDto> toListIdDto(List<Passenger> passengers){
        List<PassengerIdDto> passengerIdDtos = new ArrayList<>();
        for(Passenger passenger : passengers){
            passengerIdDtos.add(toIdDto(passenger));
        }
        return passengerIdDtos;
    }
    public List<Passenger> toListEntity(List<PassengerDto> passengersDto){
        List<Passenger> passengers = new ArrayList<>();
        for(PassengerDto passengerDto : passengersDto){
            passengers.add(toEntity(passengerDto));
        }
        return passengers;
    }
}
