package org.example.airport.model.services;

import org.example.airport.model.entities.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client saveClient(Client client);
    Optional<Client> getById(Long id);
    List<Client> getAllClients();
    List<Client>getAllClientsByIds(List<Long> ids);
    List<Client> getAllClientsByName(String name);
    Optional updateClient(Long id, Client client);
    void deleteClient(Long id);
}
