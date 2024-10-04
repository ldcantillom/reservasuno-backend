package org.example.airport.model.dtos;


public record PassengerDto(String firstName,
                           String lastName,
                           String address,
                           String cell,
                           String email,
                           String identificationNumber,
                           ReserveDto reserveDto ) {
}
