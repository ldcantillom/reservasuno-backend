package org.example.airport.model.dtos;

import java.time.LocalDateTime;
import java.util.List;

public record ReserveIdDto(Long id,
                           ClientDto client,
                           LocalDateTime reservationDate,
                           int numberOfSeats,
                           List<PassengerDto> passangers,
                           List<FlightDto> flights) {
}
