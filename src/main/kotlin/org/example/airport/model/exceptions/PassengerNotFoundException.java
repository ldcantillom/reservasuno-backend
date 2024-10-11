package org.example.airport.model.exceptions;

import lombok.Data;

@Data
public class PassengerNotFoundException extends RuntimeException {
    public PassengerNotFoundException() {
        this("Pasajero no encontrado.");
    }
    public PassengerNotFoundException(String message) {
        super(message);
    }
    public PassengerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
