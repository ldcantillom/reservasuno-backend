package org.example.airport.model.serviceimplement;

import org.example.airport.model.entities.Passenger;
import org.example.airport.model.repositories.PassengerRepository;
import org.example.airport.model.services.PassengerService;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

public class PassengerServiceImpl implements PassengerService {
    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }
    private PassengerRepository passengerRepository;

    @Override
    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public Optional<Passenger> findById(long id) {
        return passengerRepository.findById(id);
    }

    @Override
    public List<Passenger> findAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public List<Passenger> findAllPassengersByIds(List<Long> ids) {
        return passengerRepository.findAllById(ids);
    }

    @Override
    public List<Passenger> findAllPassengersByFirstName(String firstName) {
        Passenger p = new Passenger();
        p.setFirstName(firstName);
        Example<Passenger> example = Example.of(p);
        return passengerRepository.findAll(example);
    }

    @Override
    public List<Passenger> findAllPassengersByLastName(String lastName) {
        Passenger p = new Passenger();
        p.setLastName(lastName);
        Example<Passenger> example = Example.of(p);
        return passengerRepository.findAll(example);
    }

    @Override
    public List<Passenger> findAllPassengersByEmail(String email) {
        Passenger p = new Passenger();
        p.setEmail(email);
        Example<Passenger> example = Example.of(p);
        return passengerRepository.findAll(example);
    }

    @Override
    public List<Passenger> findAllPassengersByPhone(String phone) {
        Passenger p = new Passenger();
        p.setCell(phone);
        Example<Passenger> example = Example.of(p);
        return passengerRepository.findAll(example);
    }

    @Override
    public List<Passenger> findAllPassengersByAddress(String address) {
        Passenger p = new Passenger();
        p.setAddress(address);
        Example<Passenger> example = Example.of(p);
        return passengerRepository.findAll(example);
    }

    @Override
    public Optional<Passenger> updatePassenger(Long id, Passenger passenger) {
        return passengerRepository.findById(id).map(oldPassenger -> {
            oldPassenger.setFirstName(passenger.getFirstName());
            oldPassenger.setLastName(passenger.getLastName());
            oldPassenger.setEmail(passenger.getEmail());
            oldPassenger.setAddress(passenger.getAddress());
            oldPassenger.setCell(passenger.getCell());
            return passengerRepository.save(oldPassenger);
        });
    }

    @Override
    public void deletePassenger(Passenger passenger) {
        passengerRepository.delete(passenger);
    }
}
