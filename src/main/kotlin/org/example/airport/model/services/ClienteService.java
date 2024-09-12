package org.example.airport.model.services;

import org.example.airport.model.entities.Client;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
    Client guardar(Client cliente);
    Optional<Client> buscarPorId(Long id);
    List<Client> buscarClientes();
    List<Client>buscarClientesbyIds(List<Long> ids);
    List<Client> buscaClientebyNombre(String nombre);
    Optional actualizarCliente(Long id, Client cliente);
}
