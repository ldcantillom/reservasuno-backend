package org.example.airport.model.exceptions;

public class ReserveNotFoundException extends RuntimeException {
    public ReserveNotFoundException() {
        this("Reserva no encontrada.");
    }
    public ReserveNotFoundException(String message) {
        super(message);
    }
    public ReserveNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
