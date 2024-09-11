package org.example.airport.model.services;
import org.example.airport.model.repositories.ClienteRepository;
import org.example.airport.model.Client;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements ClienteService {
    private ClienteRepository clienteRepository;
    public ClienteServiceImpl(ClienteRepository clienteRepository) {this.clienteRepository = clienteRepository;}

    @Override
    public Client guardar(Client cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Client> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Client> buscarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Client> buscarClientesbyIds(List<Long> ids) {
        return clienteRepository.findAllById(ids);
    }

    @Override
    public List<Client> buscaClientebyNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }

    @Override
    public Optional<Client> actualizarCliente(Long id, Client cliente) {
        return clienteRepository.findById(id).map(oldClient -> {
            oldClient.setFirstName(cliente.getFirstName());
            oldClient.setLastName(cliente.getLastName());
            oldClient.setEmail(cliente.getEmail());
            oldClient.setDirection(cliente.getDirection());
            oldClient.setCell(cliente.getCell());
            return clienteRepository.save(oldClient);
        });
    }
}
