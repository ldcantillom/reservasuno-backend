package org.example.airport.model.services;

import org.example.airport.model.entities.Client;
import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client saveClient(Client client);
    Optional<Client> findById(Long id);
    List<Client> findAllClients();
    List<Client>findAllClientsByIds(List<Long> ids);
    List<Client> findAllClientsByName(String name);
    Optional updateClient(Long id, Client client);
    void deleteClient(Long id);
}
