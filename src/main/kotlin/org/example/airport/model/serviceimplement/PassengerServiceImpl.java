package org.example.airport.model.serviceimplement;

import lombok.AllArgsConstructor;
import org.example.airport.model.dtos.PassengerDto;
import org.example.airport.model.dtos.PassengerIdDto;
import org.example.airport.model.entities.Passenger;
import org.example.airport.model.mapper.PassengerMapper;
import org.example.airport.model.repositories.ClientRepository;
import org.example.airport.model.repositories.PassengerRepository;
import org.example.airport.model.services.PassengerService;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Lazy))
public class PassengerServiceImpl implements PassengerService {
    private PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper;
    @Override
    public PassengerIdDto savePassenger(PassengerDto passengerDto) {
        return passengerMapper.toIdDto(passengerRepository.save(passengerMapper.toEntity(passengerDto)));
    }

    @Override
    public Optional<PassengerIdDto> getById(long id) {
        return Optional.of(passengerMapper.toIdDto(passengerRepository.findById(id).get()));
    }

    @Override
    public List<PassengerIdDto> getAllPassengers() {
        return passengerMapper.toListIdDto(passengerRepository.findAll());
    }

    @Override
    public List<PassengerIdDto> getAllPassengersByIds(List<Long> ids) {
        return passengerMapper.toListIdDto(passengerRepository.findAllById(ids));
    }

    @Override
    public List<PassengerIdDto> getAllPassengersByName(String firstName) {
        Passenger p = new Passenger();
        p.setFirstName(firstName);
        Example<Passenger> example = Example.of(p);
        return passengerMapper.toListIdDto(passengerRepository.findAll(example));
    }

    @Override
    public List<PassengerIdDto> getAllPassengersByEmail(String email) {
        Passenger p = new Passenger();
        p.setEmail(email);
        Example<Passenger> example = Example.of(p);
        return passengerMapper.toListIdDto(passengerRepository.findAll(example));
    }

    @Override
    public List<PassengerIdDto> getAllPassengersByPhone(String phone) {
        Passenger p = new Passenger();
        p.setCell(phone);
        Example<Passenger> example = Example.of(p);
        return passengerMapper.toListIdDto(passengerRepository.findAll(example));
    }

    @Override
    public List<PassengerIdDto> getAllPassengersByAddress(String address) {
        Passenger p = new Passenger();
        p.setAddress(address);
        Example<Passenger> example = Example.of(p);
        return passengerMapper.toListIdDto(passengerRepository.findAll(example));
    }

    @Override
    public Optional<PassengerIdDto> updatePassenger(Long id, PassengerDto passengerDto) {
        return passengerRepository.findById(id).map(oldPassenger -> {
            oldPassenger.setFirstName(passengerDto.firstName());
            oldPassenger.setLastName(passengerDto.lastName());
            oldPassenger.setAddress(passengerDto.address());
            oldPassenger.setCell(passengerDto.cell());
            oldPassenger.setEmail(passengerDto.email());
            oldPassenger.setIdentificationNumber(passengerDto.identificationNumber());
            oldPassenger.setReserve(passengerMapper.toEntity(passengerDto).getReserve());
            return passengerMapper.toIdDto(passengerRepository.save(oldPassenger));
        });
    }


    @Override
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
