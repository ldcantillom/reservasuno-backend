package org.example.airport.model.dtos;

import java.util.Set;

public record SignUpRequest (String username, String password, String email, Set<String> roles){
}
