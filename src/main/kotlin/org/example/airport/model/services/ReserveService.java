package org.example.airport.model.services;

import org.example.airport.model.entities.Airport;
import org.example.airport.model.entities.Client;
import org.example.airport.model.entities.Flight;
import org.example.airport.model.entities.Reserve;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReserveService {
    Reserve saveReserve(Reserve reserve);
    Optional<Reserve> findReserveById(Long id);
    List<Reserve> findAllReserves();
    List<Reserve> findAllReservesByDate(LocalDateTime date);
    List<Reserve> findAllReservesByClient(Client client);
    Optional<Reserve> updateReserve(Long id, Reserve reserve,Client client);
    void deleteReserveById(Long id);
}
