package org.example.airport.model.api;

import org.example.airport.model.entities.Flight;
import org.example.airport.model.entities.Flight;
import org.example.airport.model.services.FlightService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {
    private final FlightService flightService;
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping()
    public ResponseEntity<List<Flight>> getAllFlights() {
        return ResponseEntity.ok(flightService.getAllFlights());
    }

    @GetMapping("/id")
    public ResponseEntity<Flight> getFlightById(@RequestParam Long id) {
        return flightService.getFlightById(id)
                .map( a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        return createNewFlight(flight);

        // Flight c = flightService.saveFlight(flight);
        // return ResponseEntity.created(new URI("/api/v1/flights/" + c.getId())).body(c);
        // Thowght the exception.
    }

    @PutMapping("/id")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        Optional<Flight> flightUpdated = flightService.updateFlight(id, flight);
        return flightUpdated
                .map(c -> ResponseEntity.ok(c))
                .orElseGet(() -> {
                    return createNewFlight(flight);
                });
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }

    @NotNull
    private static ResponseEntity<Flight> createNewFlight(Flight c) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(c.getId())
                .toUri();
        return ResponseEntity.created(location).body(c);
    }
}