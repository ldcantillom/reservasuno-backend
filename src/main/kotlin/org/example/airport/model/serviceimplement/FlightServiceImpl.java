package org.example.airport.model.serviceimplement;

import org.example.airport.model.entities.Airport;
import org.example.airport.model.entities.Flight;
import org.example.airport.model.repositories.FlightRepository;
import org.example.airport.model.services.FlightService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flighRepository = flightRepository;
    }
    private FlightRepository flighRepository;


    @Override
    public Flight saveFlight(Flight flight) {
        return flighRepository.save(flight);
    }

    @Override
    public Optional<Flight> findFlightById(Long id) {
        return flighRepository.findById(id);
    }

    @Override
    public List<Flight> findAllFlights() {
        return flighRepository.findAll();
    }

    @Override
    public List<Flight> findAllFlightsByIds(List<Long> ids) {
        return flighRepository.findAllById(ids);
    }

    @Override
    public List<Flight> findAllFlightsByAirport(Airport airport) {
        Flight flight = new Flight();
        flight.setAirport_origin(airport);
        Example<Flight> example = Example.of(flight);
        return flighRepository.findAll(example);
    }

    @Override
    public List<Flight> findAllFlightsByDate(LocalDateTime date) {
        Flight flight = new Flight();
        flight.setDeparture_time(date);
        Example<Flight> example = Example.of(flight);
        return flighRepository.findAll(example);
    }

    @Override
    public List<Flight> findAllFlightsByAirportAndDate(Airport airport, LocalDateTime date) {
        Flight flight = new Flight();
        flight.setAirport_origin(airport);
        flight.setDeparture_time(date);
        Example<Flight> example = Example.of(flight);
        return flighRepository.findAll(example);
    }



    @Override
    public Optional<Flight> updateFlight(Long id,Flight flight) {
        return flighRepository.findById(id).map(oldFligh -> {
            oldFligh.setDeparture_time(flight.getDeparture_time());
            oldFligh.setAirport_origin(flight.getAirport_origin());
            oldFligh.setAirlane(flight.getAirlane());
            oldFligh.setCapacity(flight.getCapacity());
            oldFligh.setArrival_time(flight.getArrival_time());
            oldFligh.setReserves(flight.getReserves());
            oldFligh.setAirport_destination(flight.getAirport_destination());
            return flighRepository.save(oldFligh);
        });
    }

    @Override
    public void deleteFlight(Long id) { flighRepository.deleteById(id); }
}
