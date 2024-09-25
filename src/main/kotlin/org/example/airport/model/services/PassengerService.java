package org.example.airport.model.services;

import org.example.airport.model.entities.Passenger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
    Passenger savePassenger(Passenger passenger);
    Optional<Passenger> getById(long id);
    List<Passenger> getAllPassengers();
    List<Passenger> getAllPassengersByIds(List<Long> ids);
    List<Passenger> getAllPassengersByFirstName(String firstName);
    List<Passenger> getAllPassengersByLastName(String lastName);
    List<Passenger> getAllPassengersByEmail(String email);
    List<Passenger> getAllPassengersByPhone(String phone);
    List<Passenger> getAllPassengersByAddress(String address);
    Optional<Passenger> updatePassenger(Long id, Passenger passenger);
    void deletePassenger(Long id);
}
