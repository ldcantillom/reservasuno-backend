package org.example.airport.model.api;

import org.example.airport.model.dtos.ClientDto;
import org.example.airport.model.dtos.ClientIdDto;
import org.example.airport.model.services.ClientService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.lang.Long;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) { this.clientService = clientService; }

    @GetMapping()
    public ResponseEntity<List<ClientIdDto>> getAllClients(@RequestParam(required = false, value = "name") String name) {
        return ResponseEntity.ok(clientService.getAllClientsByName(name));
    }

    @GetMapping("/id")
    public ResponseEntity<ClientIdDto> getClientById(@PathVariable Long id) {
        return clientService.getById(id)
                .map( c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<ClientIdDto> createClient(@RequestBody ClientDto clientDto) {
        return createNewClient(clientDto);

        // Client c = clientService.saveClient(client);
        // return ResponseEntity.created(new URI("/api/v1/clients/" + c.getId())).body(c);
        // Thowght the exception.
    }
    
    @PutMapping("/id")
    public ResponseEntity<ClientIdDto> updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        Optional<ClientIdDto> clientUpdated = clientService.updateClient(id, clientDto);
        return clientUpdated
                .map(c -> ResponseEntity.ok(c))
                .orElseGet(() -> {
                    return createNewClient(clientDto);
                });
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @NotNull
    private ResponseEntity<ClientIdDto> createNewClient(ClientDto c) {
        ClientIdDto clientSaved = clientService.saveClient(c);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clientSaved.id())
                .toUri();
        return ResponseEntity.created(location).body(clientSaved);
    }
}
