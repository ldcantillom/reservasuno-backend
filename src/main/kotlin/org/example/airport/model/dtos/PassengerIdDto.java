package org.example.airport.model.dtos;

public record PassengerIdDto(Long id,
                             String firatName,
                             String lastName,
                             String Adress,
                             String cell,
                             String email,
                             String cedula,
                             ReserveDto reserveDto) {
}
