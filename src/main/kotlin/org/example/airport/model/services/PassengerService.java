package org.example.airport.model.services;

import org.example.airport.model.dtos.PassengerDto;
import org.example.airport.model.dtos.PassengerIdDto;
import org.example.airport.model.entities.Passenger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
    PassengerIdDto savePassenger(PassengerDto passengerDto);
    Optional<PassengerIdDto> getById(long id);
    List<PassengerIdDto> getAllPassengers();
    List<PassengerIdDto> getAllPassengersByIds(List<Long> ids);
    List<PassengerIdDto> getAllPassengersByName(String firstName);
    List<PassengerIdDto> getAllPassengersByEmail(String email);
    List<PassengerIdDto> getAllPassengersByPhone(String phone);
    List<PassengerIdDto> getAllPassengersByAddress(String address);
    Optional<PassengerIdDto> updatePassenger(Long id, PassengerDto passengerDto);
    void deletePassenger(Long id);
}
