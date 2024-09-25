package org.example.airport.model.api;

import org.example.airport.model.entities.Airlane;
import org.example.airport.model.services.AirlaneService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/airlines")
public class AirlaneController {
    private final AirlaneService airlaneService;
    public AirlaneController(AirlaneService airlaneService) {
        this.airlaneService = airlaneService;
    }

    @GetMapping()
    public ResponseEntity<List<Airlane>> getAllAirlanes() {
        return ResponseEntity.ok(airlaneService.findAllAirlanes());
    }

    @GetMapping("id")
    public ResponseEntity<Airlane> getAirlaneById(@RequestParam Long id) {
        return airlaneService.findAirlaneById(id)
                .map( a -> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Airlane> createAirlane(@RequestBody Airlane Airlane) {
        return createNewAirlane(Airlane);

        // Airlane c = AirlaneService.saveAirlane(Airlane);
        // return ResponseEntity.created(new URI("/api/v1/Airlanes/" + c.getId())).body(c);
        // Thowght the exception.
    }

    @PutMapping("/id")
    public ResponseEntity<Airlane> updateAirlane(@PathVariable Long id, @RequestBody Airlane Airlane) {
        Optional<Airlane> airlaneUpdated = airlaneService.updateAirlane(id, Airlane);
        return airlaneUpdated
                .map(c -> ResponseEntity.ok(c))
                .orElseGet(() -> {
                    return createNewAirlane(Airlane);
                });
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteAirlane(@PathVariable Long id) {
        airlaneService.deleteAirlane(id);
        return ResponseEntity.noContent().build();
    }

    @NotNull
    private static ResponseEntity<Airlane> createNewAirlane(Airlane c) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(c.getId())
                .toUri();
        return ResponseEntity.created(location).body(c);
    }
}
