package org.example.airport.model.serviceimplement;

import org.example.airport.model.entities.Passenger;
import org.example.airport.model.repositories.PassengerRepository;
import org.example.airport.model.services.PassengerService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public Optional<Passenger> getById(long id) {
        return passengerRepository.findById(id);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public List<Passenger> getAllPassengersByIds(List<Long> ids) {
        return passengerRepository.findAllById(ids);
    }

    @Override
    public List<Passenger> getAllPassengersByFirstName(String firstName) {
        Passenger p = new Passenger();
        p.setFirstName(firstName);
        Example<Passenger> example = Example.of(p);
        return passengerRepository.findAll(example);
    }

    @Override
    public List<Passenger> getAllPassengersByLastName(String lastName) {
        Passenger p = new Passenger();
        p.setLastName(lastName);
        Example<Passenger> example = Example.of(p);
        return passengerRepository.findAll(example);
    }

    @Override
    public List<Passenger> getAllPassengersByEmail(String email) {
        Passenger p = new Passenger();
        p.setEmail(email);
        Example<Passenger> example = Example.of(p);
        return passengerRepository.findAll(example);
    }

    @Override
    public List<Passenger> getAllPassengersByPhone(String phone) {
        Passenger p = new Passenger();
        p.setCell(phone);
        Example<Passenger> example = Example.of(p);
        return passengerRepository.findAll(example);
    }

    @Override
    public List<Passenger> getAllPassengersByAddress(String address) {
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
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
