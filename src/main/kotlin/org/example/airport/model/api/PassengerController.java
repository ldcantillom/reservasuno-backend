package org.example.airport.model.api;

import org.example.airport.model.dtos.PassengerDto;
import org.example.airport.model.dtos.PassengerIdDto;
import org.example.airport.model.exceptions.PassengerNotFoundException;
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
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping()
    public ResponseEntity<List<PassengerIdDto>> getAllPassengers() {
        return ResponseEntity.ok(passengerService.getAllPassengers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerIdDto> getPassengerById(@PathVariable Long id) {
        return passengerService.getById(id)
                .map( c -> ResponseEntity.ok().body(c))
                .orElseThrow(() -> new PassengerNotFoundException("doesnt found Passenger with id " + id ));
    }

    @PostMapping()
    public ResponseEntity<PassengerIdDto> createPassenger(@RequestBody PassengerDto passengerDto) {
        return createNewPassenger(passengerDto);

        // Passenger c = passengerService.savePassenger(passenger);
        // return ResponseEntity.created(new URI("/api/v1/passengers/" + c.getId())).body(c);
        // Thowght the exception.
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassengerIdDto> updatePassenger(@PathVariable Long id, @RequestBody PassengerDto passengerDto) {
        Optional<PassengerIdDto> passengerUpdated = passengerService.updatePassenger(id, passengerDto);
        return passengerUpdated
                .map(c -> ResponseEntity.ok(c))
                .orElseGet(() -> {
                    return createNewPassenger(passengerDto);
                });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }

    @NotNull
    private ResponseEntity<PassengerIdDto> createNewPassenger(PassengerDto p) {
        PassengerIdDto passangerSaved = passengerService.savePassenger(p);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(passangerSaved.id())
                .toUri();
        return ResponseEntity.created(location).body(passangerSaved);
    }

}
