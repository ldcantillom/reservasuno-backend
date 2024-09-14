package org.example.airport.model.services;

import org.example.airport.model.entities.Passenger;
import java.util.List;
import java.util.Optional;

public interface PassengerService {
    Passenger savePassenger(Passenger passenger);
    Optional<Passenger> findById(long id);
    List<Passenger> findAllPassengers();
    List<Passenger> findAllPassengersByIds(List<Long> ids);
    List<Passenger> findAllPassengersByFirstName(String firstName);
    List<Passenger> findAllPassengersByLastName(String lastName);
    List<Passenger> findAllPassengersByEmail(String email);
    List<Passenger> findAllPassengersByPhone(String phone);
    List<Passenger> findAllPassengersByAddress(String address);
    Optional<Passenger> updatePassenger(Long id, Passenger passenger);
    void deletePassenger(Passenger passenger);
}
