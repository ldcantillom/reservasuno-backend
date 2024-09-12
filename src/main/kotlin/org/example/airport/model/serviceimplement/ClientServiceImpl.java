package org.example.airport.model.serviceimplement;
import org.example.airport.model.repositories.ClientRepository;
import org.example.airport.model.entities.Client;
import org.example.airport.model.services.ClientService;

import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    private ClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> searchById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> searchForClients() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> searchClientsbyIds(List<Long> ids) {
        return clientRepository.findAllById(ids);
    }

    @Override
    public List<Client> searchClientbyName(String name) {
        return clientRepository.findByNombre(name);
    }

    @Override
    public Optional<Client> updateClient(Long id, Client client) {
        return clientRepository.findById(id).map(oldClient -> {
            oldClient.setFirstName(client.getFirstName());
            oldClient.setLastName(client.getLastName());
            oldClient.setEmail(client.getEmail());
            oldClient.setDirection(client.getDirection());
            oldClient.setCell(client.getCell());
            return clientRepository.save(oldClient);
        });
    }
}
