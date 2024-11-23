package org.example.airport.model.dtos;

public record ClientDto(String firstName,
                        String lastName,
                        String address,
                        String cell,
                        String email
                        ) {
}