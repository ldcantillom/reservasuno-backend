package org.example.airport.model.api;

import org.example.airport.model.entities.Airport;
import org.example.airport.model.services.AirportService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/airports")
public class AirportController {
    private AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping()
    public ResponseEntity<List<Airport>> getAllAirports() {
        return ResponseEntity.ok(airportService.getAllAirports());
    }

    @GetMapping("id")
    public ResponseEntity<Airport> getAirportById(@PathVariable Long id) {
        return airportService.getById(id)
                .map( c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Airport> createAirport(@RequestBody Airport Airport) {
        return createNewAirport(Airport);

        // Airport c = AirportService.saveAirport(Airport);
        // return ResponseEntity.created(new URI("/api/v1/Airports/" + c.getId())).body(c);
        // Thowght the exception.
    }

    @PutMapping("/id")
    public ResponseEntity<Airport> updateAirport(@PathVariable Long id, @RequestBody Airport Airport) {
        Optional<Airport> airportUpdated = airportService.updateAirport(id, Airport);
        return airportUpdated
                .map(c -> ResponseEntity.ok(c))
                .orElseGet(() -> {
                    return createNewAirport(Airport);
                });
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
        return ResponseEntity.noContent().build();
    }

    @NotNull
    private static ResponseEntity<Airport> createNewAirport(Airport c) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(c.getId())
                .toUri();
        return ResponseEntity.created(location).body(c);
    }

}

