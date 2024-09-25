package org.example.airport.model.api;

import org.example.airport.model.entities.Client;
import org.example.airport.model.entities.Scale;
import org.example.airport.model.services.ScaleService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/scales")
public class ScaleController {
    private ScaleService scaleService;

    public ScaleController(ScaleService scaleService) {
        this.scaleService = scaleService;
    }

    @GetMapping("/scales")
    public ResponseEntity<List<Scale>> getAllScales() {
        return ResponseEntity.ok(scaleService.getAllScales());
    }

    @GetMapping("/id")
    public ResponseEntity<Scale> getScaleById(@PathVariable Long id) {
        return scaleService.getById(id)
                .map( c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Scale> createScale(@RequestBody Scale scale) {
        return createNewScale(scale);

        // Scale c = scaleService.saveScale(scale);
        // return ResponseEntity.created(new URI("/api/v1/scales/" + c.getId())).body(c);
        // Thowght the exception.
    }

    @PutMapping("/id")
    public ResponseEntity<Scale> updateScale(@PathVariable Long id, @RequestBody Scale scale) {
        Optional<Scale> scaleUpdated = scaleService.updateScale(id, scale);
        return scaleUpdated
                .map(c -> ResponseEntity.ok(c))
                .orElseGet(() -> {
                    return createNewScale(scale);
                });
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteScale(@PathVariable Long id) {
        scaleService.deleteScale(id);
        return ResponseEntity.noContent().build();
    }

    @NotNull
    private static ResponseEntity<Scale> createNewScale(Scale c) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(c.getId())
                .toUri();
        return ResponseEntity.created(location).body(c);
    }
}
