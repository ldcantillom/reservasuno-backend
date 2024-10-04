package org.example.airport.model.mapper;

import org.example.airport.model.dtos.ClientDto;
import org.example.airport.model.dtos.ClientIdDto;
import org.example.airport.model.entities.Client;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapper {

    public Client toEntity(ClientDto clientDto) {
        Client client = new Client();
        client.setFirstName(clientDto.firstname());
        client.setLastName(clientDto.lastName());
        client.setAddress(clientDto.address());
        client.setCell(clientDto.cell());
        client.setEmail(clientDto.email());
        return client;
    }

    public ClientDto toDto(Client client) {
        return new ClientDto(
                client.getFirstName(),
                client.getLastName(),
                client.getAddress(),
                client.getCell(),
                client.getEmail()
        );
    }

    public ClientIdDto toIdDto(Client client) {
        return new ClientIdDto(
                client.getId(),
                client.getFirstName(),
                client.getLastName(),
                client.getAddress(),
                client.getCell(),
                client.getEmail()
        );
    }

//    public List<ClientDto> toListDto(List<Client> clients) {
//        List<ClientDto> clientDtos = new ArrayList<>();
//        for (Client client : clients) {
//            clientDtos.add(toDto(client));
//        }
//        return clientDtos;
//    }

    public List<ClientIdDto> toListIdDto(List<Client> clients) {
        List<ClientIdDto> clientIdDtos = new ArrayList<>();
        for (Client client : clients) {
            clientIdDtos.add(toIdDto(client));
        }
        return clientIdDtos;
    }
}
