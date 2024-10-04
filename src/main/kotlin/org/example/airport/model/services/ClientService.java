package org.example.airport.model.services;

import org.example.airport.model.dtos.ClientDto;
import org.example.airport.model.dtos.ClientIdDto;
import org.example.airport.model.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    ClientIdDto saveClient(ClientDto clientDto);
    Optional<ClientIdDto> getById(Long id);
    List<ClientIdDto> getAllClients();
    List<ClientIdDto>getAllClientsByIds(List<Long> ids);
    List<ClientIdDto> getAllClientsByName(String name);
    Optional updateClient(Long id, ClientDto clientDto);
    void deleteClient(Long id);
}
