package org.example.airport.model.api;

import org.example.airport.model.entities.Client;
import org.example.airport.model.entities.Reserve;
import org.example.airport.model.exceptions.ReserveNotFoundException;
import org.example.airport.model.services.ReserveService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reserves")
public class ReserveController {
    private ReserveService reserveService;

    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @GetMapping()
    public ResponseEntity<List<Reserve>> getAllReserves() {
        return ResponseEntity.ok(reserveService.getAllReserves());
    }

    @GetMapping("/id")
    public ResponseEntity<Reserve> getReserveById(@PathVariable Long id) {
        return reserveService.getReserveById(id)
                .map( c -> ResponseEntity.ok().body(c))
                .orElseThrow(() -> new ReserveNotFoundException("Doesnt found Reserve with"+id));
    }

    @PostMapping()
    public ResponseEntity<Reserve> createReserve(@RequestBody Reserve reserve) {
        return createNewReserve(reserve);

        // Reserve c = reserveService.saveReserve(reserve);
        // return ResponseEntity.created(new URI("/api/v1/reserves/" + c.getId())).body(c);
        // Thowght the exception.
    }

    @PutMapping("/id")
    public ResponseEntity<Reserve> updateReserve(@PathVariable Long id, @RequestBody Reserve reserve) {
        Optional<Reserve> reserveUpdated = reserveService.updateReserve(id, reserve);
        return reserveUpdated
                .map(c -> ResponseEntity.ok(c))
                .orElseGet(() -> {
                    return createNewReserve(reserve);
                });
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteReserve(@PathVariable Long id) {
        reserveService.deleteReserve(id);
        return ResponseEntity.noContent().build();
    }

    @NotNull
    private static ResponseEntity<Reserve> createNewReserve(Reserve c) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(c.getId())
                .toUri();
        return ResponseEntity.created(location).body(c);
    }
}
