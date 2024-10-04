package org.example.airport.model.mapper;

import lombok.AllArgsConstructor;
import org.example.airport.model.dtos.FlightDto;
import org.example.airport.model.entities.Flight;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class FlightMapper {
    private AirlaneMapper airlaneMapper;
    private AirportMapper airportMapper;
    private ReserveMapper reserveMapper;

    public Flight toEntity(FlightDto flightDto){
        Flight flight = new Flight();
        flight.setAirlane(airlaneMapper.toEntity(flightDto.airlane()));
        flight.setAirportOrigin(airportMapper.toEntity(flightDto.airport_origin()));
        flight.setAirportDestination(airportMapper.toEntity(flightDto.airport_destination()));
        flight.setDepartureTime(flightDto.departure_time());
        flight.setArrivalTime(flightDto.arrival_time());
        flight.setCapacity(flightDto.capacity());
        flight.setReserves(reserveMapper.toListEntity(flightDto.reserves()));
        return flight;
    }
    public FlightDto toDto(Flight flight){
        FlightDto flightDto = new FlightDto(
        airlaneMapper.toDto(flight.getAirlane()),
        airportMapper.toDto(flight.getAirportOrigin()),
        airportMapper.toDto(flight.getAirportDestination()),
        flight.getDepartureTime(),
        flight.getArrivalTime(),
        flight.getCapacity(),
        reserveMapper.toListDto(flight.getReserves())
        );
        return flightDto;

    }
    public List<Flight> toListEntity(List<FlightDto> flightsDto){
        List<Flight> flights = new ArrayList<>();
        for(FlightDto flightDto : flightsDto){
            flights.add(toEntity(flightDto));
        }
        return flights;
    }
    public List<FlightDto> toListDto(List<Flight> flights){
        List<FlightDto> flightsDto = new ArrayList<>();
        for(Flight flight : flights){
            flightsDto.add(toDto(flight));
        }
        return flightsDto;
    }
}
