package org.example.airport.model.api;

import org.example.airport.model.entities.Passenger;
import org.example.airport.model.services.PassengerService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/passenger")
public class PassengerController {
    private PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping()
    public ResponseEntity<List<Passenger>> getAllPassengers() {
        return ResponseEntity.ok(passengerService.getAllPassengers());
    }

    @GetMapping("/id")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id) {
        return passengerService.getById(id)
                .map( c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {
        return createNewPassenger(passenger);

        // Passenger c = passengerService.savePassenger(passenger);
        // return ResponseEntity.created(new URI("/api/v1/passengers/" + c.getId())).body(c);
        // Thowght the exception.
    }

    @PutMapping("/id")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
        Optional<Passenger> passengerUpdated = passengerService.updatePassenger(id, passenger);
        return passengerUpdated
                .map(c -> ResponseEntity.ok(c))
                .orElseGet(() -> {
                    return createNewPassenger(passenger);
                });
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }

    @NotNull
    private static ResponseEntity<Passenger> createNewPassenger(Passenger c) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(c.getId())
                .toUri();
        return ResponseEntity.created(location).body(c);
    }
}
