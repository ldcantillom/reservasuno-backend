package org.example.airport.model.dtos;

public record ClientDto(String firstname,
                        String lastName,
                        String address,
                        String cell,
                        String email
                        ) {
}