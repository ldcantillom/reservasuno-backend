package org.example.airport.model.api;

import org.example.airport.model.entities.Client;
import org.example.airport.model.services.ClientService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.lang.Long;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public ResponseEntity<List<Client>> getAllClients(@RequestParam(required = false, value = "name") String name) {
        return ResponseEntity.ok(clientService.getAllClientsByName(name));
    }

    @GetMapping("/id")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return clientService.getById(id)
                .map( c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return createNewClient(client);

        // Client c = clientService.saveClient(client);
        // return ResponseEntity.created(new URI("/api/v1/clients/" + c.getId())).body(c);
        // Thowght the exception.
    }
    
    @PutMapping("/id")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        Optional<Client> clientUpdated = clientService.updateClient(id, client);
        return clientUpdated
                .map(c -> ResponseEntity.ok(c))
                .orElseGet(() -> {
                    return createNewClient(client);
                });
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @NotNull
    private static ResponseEntity<Client> createNewClient(Client c) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(c.getId())
                .toUri();
        return ResponseEntity.created(location).body(c);
    }
}
