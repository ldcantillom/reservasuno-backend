package org.example.airport.model.services;

import org.example.airport.model.entities.Client;
import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client save(Client client);
    Optional<Client> searchById(Long id);
    List<Client> searchForClients();
    List<Client>searchClientsbyIds(List<Long> ids);
    List<Client> searchClientbyName(String name);
    Optional updateClient(Long id, Client client);
}
