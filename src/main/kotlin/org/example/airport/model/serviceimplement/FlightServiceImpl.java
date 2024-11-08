package org.example.airport.model.serviceimplement;

import lombok.AllArgsConstructor;
import org.example.airport.model.entities.Airport;
import org.example.airport.model.entities.Flight;
import org.example.airport.model.repositories.FlightRepository;
import org.example.airport.model.services.FlightService;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Lazy))
public class FlightServiceImpl implements FlightService {
    private FlightRepository flighRepository;


    @Override
    public Flight saveFlight(Flight flight) {
        return flighRepository.save(flight);
    }

    @Override
    public Optional<Flight> getFlightById(Long id) {
        return flighRepository.findById(id);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flighRepository.findAll();
    }

    @Override
    public List<Flight> getAllFlightsByIds(List<Long> ids) {
        return flighRepository.findAllById(ids);
    }

    @Override
    public List<Flight> getAllFlightsByAirport(Airport airport) {
        Flight flight = new Flight();
        flight.setAirportOrigin(airport);
        Example<Flight> example = Example.of(flight);
        return flighRepository.findAll(example);
    }

    @Override
    public List<Flight> getAllFlightsByDate(LocalDateTime date) {
        Flight flight = new Flight();
        flight.setDepartureTime(date);
        Example<Flight> example = Example.of(flight);
        return flighRepository.findAll(example);
    }

    @Override
    public List<Flight> getAllFlightsByAirportAndDate(Airport airport, LocalDateTime date) {
        Flight flight = new Flight();
        flight.setAirportOrigin(airport);
        flight.setDepartureTime(date);
        Example<Flight> example = Example.of(flight);
        return flighRepository.findAll(example);
    }



    @Override
    public Optional<Flight> updateFlight(Long id,Flight flight) {
        return flighRepository.findById(id).map(oldFligh -> {
            oldFligh.setDepartureTime(flight.getDepartureTime());
            oldFligh.setAirportOrigin(flight.getAirportOrigin());
            oldFligh.setAirportDestination(flight.getAirportDestination());
            oldFligh.setAirlane(flight.getAirlane());
            oldFligh.setCapacity(flight.getCapacity());
            oldFligh.setArrivalTime(flight.getArrivalTime());
            oldFligh.setReserves(flight.getReserves());
            return flighRepository.save(oldFligh);
        });
    }

    @Override
    public void deleteFlight(Long id) { flighRepository.deleteById(id); }
}
