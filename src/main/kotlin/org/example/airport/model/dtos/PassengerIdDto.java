package org.example.airport.model.dtos;

public record PassengerIdDto(Long id,
                             String firstName,
                             String lastName,
                             String adress,
                             String cell,
                             String email,
                             String identificationNumber,
                             ReserveDto reserve) {
}
