package org.example.airport.model.services;

import org.example.airport.model.dtos.ClientDto;
import org.example.airport.model.dtos.ReserveDto;
import org.example.airport.model.entities.Client;
import org.example.airport.model.entities.Reserve;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReserveService {
    ReserveDto save(ReserveDto reserve);
    Optional<ReserveDto> findById(int id);
    Optional<ReserveDto> update(int id, ReserveDto reserve);
    List<ReserveDto> findAll();
    List<ReserveDto> findByClient(ClientDto client);
    List<ReserveDto> findByDate(LocalDateTime date);
    void deleteById(int id);
}
