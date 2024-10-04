package org.example.airport.model.dtos;

public record ClientIdDto(Long id,
                          String firstname,
                          String lastName,
                          String address,
                          String cell,
                          String email
                              ) {
}
