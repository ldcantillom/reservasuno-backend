package org.example.airport.model.serviceimplement;
import org.example.airport.model.repositories.AirportRepository;
import org.example.airport.model.entities.Airport;
import org.example.airport.model.services.AirportService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {
    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository=airportRepository;
    }
    private AirportRepository airportRepository;

    @Override
    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public Optional<Airport> findById(Long id) {
        return airportRepository.findById(id);
    }

    @Override
    public List<Airport> findAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public List<Airport> findAllAirportsByIds(List<Long> ids) {
        return airportRepository.findAllById(ids);
    }

    @Override
    public List<Airport> findAllAirportsByName(String airportName) {
        Airport a = new Airport() ;
        a.setName(airportName);
        Example<Airport> example = Example.of(a);
        return airportRepository.findAll(Example.of(a));
    }

    @Override
    public List<Airport> findAllAirportsByCity(String city) {
        Airport a = new Airport() ;
        a.setCity(city);
        Example<Airport> example = Example.of(a);
        return airportRepository.findAll(Example.of(a));
    }

    @Override
    public List<Airport> findAllAirportByCountry(String country) {
        Airport a = new Airport();
        a.setCountry(country);
        Example<Airport> example= Example.of(a);
        return airportRepository.findAll(Example.of(a));
    }

    @Override
    public Optional<Airport> updateAirport(Long id, Airport airport) {
        return airportRepository.findById(id).map(oldAirport -> {
            oldAirport.setName(airport.getName());
            oldAirport.setCity(airport.getCity());
            oldAirport.setCountry(airport.getCountry());
            oldAirport.setFlights(airport.getFlights());
            return airportRepository.save(oldAirport);
        });
    }

    @Override
    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);

    }
}
