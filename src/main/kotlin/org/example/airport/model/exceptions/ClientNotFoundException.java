package org.example.airport.model.exceptions;

import lombok.Data;

@Data
public class ClientNotFoundException extends ResourceNotFoundException {
    public ClientNotFoundException() {
        this("Cliente no encontrado");
    }
    public ClientNotFoundException(String message) {
        super(message);
    }
    public ClientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
