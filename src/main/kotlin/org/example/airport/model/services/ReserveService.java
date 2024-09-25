package org.example.airport.model.services;

import org.example.airport.model.entities.Client;
import org.example.airport.model.entities.Reserve;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReserveService {
    Reserve saveReserve(Reserve reserve);
    Optional<Reserve> getReserveById(Long id);
    List<Reserve> getAllReserves();
    List<Reserve> getAllReservesByDate(LocalDateTime date);
    List<Reserve> getAllReservesByClient(Client client);
    Optional<Reserve> updateReserve(Long id, Reserve reserve);
    void deleteReserve(Long id);
}
