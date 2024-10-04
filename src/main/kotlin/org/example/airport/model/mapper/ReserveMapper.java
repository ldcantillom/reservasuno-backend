package org.example.airport.model.mapper;

import lombok.AllArgsConstructor;
import org.example.airport.model.dtos.ReserveDto;
import org.example.airport.model.dtos.ReserveIdDto;
import org.example.airport.model.entities.Reserve;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ReserveMapper {
    ClientMapper clientMapper;
    PassengerMapper passengerMapper;
    FlightMapper flightMapper;

    public Reserve toEntity(ReserveDto reserveDto){
        Reserve reserve = new Reserve();
        reserve.setClient(clientMapper.toEntity(reserveDto.client()));
        reserve.setReservationDate(reserveDto.reservationDate());
        reserve.setPassengers(passengerMapper.toListEntity(reserveDto.passangers()));
        return reserve;
    }
    public ReserveDto toDto(Reserve reserve){
        ReserveDto reserveDto = new ReserveDto(
                clientMapper.toDto(reserve.getClient()),
                reserve.getReservationDate(),
                reserve.getNumberOfSeats(),
                passengerMapper.toListDto(reserve.getPassengers()),
                flightMapper.toListDto(reserve.getFlights())
        );
        return reserveDto;
    }
    public List<ReserveDto> toListDto(List<Reserve> reserveList){
        List<ReserveDto> reserveDtoList = new ArrayList<>();
        for (Reserve reserve : reserveList){
            reserveDtoList.add(toDto(reserve));
        }
        return reserveDtoList;
    }
    public List<Reserve> toListEntity(List<ReserveDto> reserveDtoList){
        List<Reserve> reserveList = new ArrayList<>();
        for (ReserveDto reserveDto : reserveDtoList){
            reserveList.add(toEntity(reserveDto));
        }
        return reserveList;
    }
}
