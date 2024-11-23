package org.example.airport.model.serviceimplement;
import lombok.AllArgsConstructor;
import org.example.airport.model.dtos.ClientDto;
import org.example.airport.model.mapper.ClientMapper;
import org.example.airport.model.dtos.ClientIdDto;
import org.example.airport.model.repositories.ClientRepository;
import org.example.airport.model.entities.Client;
import org.example.airport.model.services.ClientService;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Lazy))
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    @Override
    public ClientIdDto saveClient(ClientDto clientDto) {
        return clientMapper.toIdDto(clientRepository.save(clientMapper.toEntity(clientDto)));
    }

    @Override
    public Optional<ClientIdDto> getById(Long id) {
        return Optional.of(clientMapper.toIdDto(clientRepository.findById(id).get()));
    }

    @Override
    public List<ClientIdDto> getAllClients() {
        return clientMapper.toListIdDto(clientRepository.findAll());
    }

    @Override
    public List<ClientIdDto> getAllClientsByIds(List<Long> ids) {
        return clientMapper.toListIdDto(clientRepository.findAllById(ids));
    }

    @Override
    public List<ClientIdDto> getAllClientsByName(String name) {
        Client c = new Client();
        c.setFirstName(name);
        Example<Client> example = Example.of(c);
        return clientMapper.toListIdDto(clientRepository.findAll(example));
    }

    @Override
    public Optional<ClientIdDto> updateClient(Long id, ClientDto clientDto) {
        return clientRepository.findById(id).map(oldClient -> {
            oldClient.setFirstName(clientDto.firstName());
            oldClient.setLastName(clientDto.lastName());
            oldClient.setEmail(clientDto.email());
            oldClient.setAddress(clientDto.address());
            oldClient.setCell(clientDto.cell());
            return clientMapper.toIdDto(clientRepository.save(oldClient));
        });
    }

    @Override
    public void deleteClient(Long id) { clientRepository.deleteById(id); }
}
