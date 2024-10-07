package org.example.airport.model.mapper;

import org.example.airport.model.dtos.ClientDto;
import org.example.airport.model.dtos.ClientIdDto;
import org.example.airport.model.entities.Client;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ClientMapper {

    Client toEntity(ClientDto clientDto);
    ClientDto toDto(Client client);
    ClientIdDto toIdDto(Client client);
    List<ClientIdDto> toListIdDto(List<Client> clients);
}
