package org.example.airport.model.serviceimplement;

import org.example.airport.model.entities.Airport;
import org.example.airport.model.entities.Client;
import org.example.airport.model.entities.Flight;
import org.example.airport.model.entities.Reserve;
import org.example.airport.model.repositories.ReserveRepository;
import org.example.airport.model.services.ReserveService;
import org.springframework.data.domain.Example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ReserveServiceImpl implements ReserveService {
    public ReserveServiceImpl(ReserveRepository reserveRepository) {
        this.reserveRepository = reserveRepository;
    }
    private ReserveRepository reserveRepository;
    @Override
    public Reserve saveReserve(Reserve reserve) {
        return reserveRepository.save(reserve);
    }

    @Override
    public Optional<Reserve> findReserveById(Long id) {
        return reserveRepository.findById(id);
    }

    @Override
    public List<Reserve> findAllReserves() {
        return reserveRepository.findAll();
    }

    @Override
    public List<Reserve> findAllReservesByDate(LocalDateTime date) {
        Reserve reserve = new Reserve();
        reserve.setReservationDate(date);
        Example<Reserve> example = Example.of(reserve);
        return reserveRepository.findAll(example);
    }


    @Override
    public List<Reserve> findAllReservesByClient(Client client) {
        Reserve reserve = new Reserve();
        reserve.setClient(client);
        Example<Reserve> example = Example.of(reserve);
        return reserveRepository.findAll(example);
    }


    @Override
    public Optional<Reserve> updateReserve(Long id, Reserve reserve,Client client) {
        return reserveRepository.findById(id).map(oldReserve -> {
            oldReserve.setReservationDate(reserve.getReservationDate());
            oldReserve.setClient(reserve.getClient());
            oldReserve.setReservationDate(reserve.getReservationDate());
            oldReserve.setPassengers(reserve.getPassengers());
            oldReserve.setNumberOfSeats(reserve.getNumberOfSeats());
            oldReserve.setReserves(reserve.getReserves());
            return reserveRepository.save(oldReserve);
        });
    }

    @Override
    public void deleteReserveById(Long id) {
        reserveRepository.deleteById(id);
    }
}
