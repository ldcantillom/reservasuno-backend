package org.example.airport.model.serviceimplement;
import org.example.airport.model.repositories.ClientRepository;
import org.example.airport.model.entities.Client;
import org.example.airport.model.services.ClientService;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    private ClientRepository clientRepository;

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> findAllClientsByIds(List<Long> ids) {
        return clientRepository.findAllById(ids);
    }

    @Override
    public List<Client> findAllClientsByName(String name) {
        Client c = new Client();
        c.setFirstName(name);
        Example<Client> example = Example.of(c);
        return clientRepository.findAll(example);
    }

    @Override
    public Optional<Client> updateClient(Long id, Client client) {
        return clientRepository.findById(id).map(oldClient -> {
            oldClient.setFirstName(client.getFirstName());
            oldClient.setLastName(client.getLastName());
            oldClient.setEmail(client.getEmail());
            oldClient.setAddress(client.getAddress());
            oldClient.setCell(client.getCell());
            return clientRepository.save(oldClient);
        });
    }

    @Override
    public void deleteClient(Long id) { clientRepository.deleteById(id); }
}
