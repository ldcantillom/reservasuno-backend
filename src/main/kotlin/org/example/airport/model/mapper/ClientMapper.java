package org.example.airport.model.mapper;

import org.example.airport.model.dtos.ClientDto;
import org.example.airport.model.dtos.ClientIdDto;
import org.example.airport.model.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client toEntity(ClientDto clientDto);
    ClientDto toDto(Client client);
    ClientIdDto toIdDto(Client client);
    List<ClientIdDto> toListIdDto(List<Client> clients);
}
