package org.example.airport.model.mapper;

import org.example.airport.model.dtos.ReserveDto;
import org.example.airport.model.dtos.ReserveIdDto;
import org.example.airport.model.entities.Reserve;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReserveMapper {
    ReserveMapper reserveMapper = Mappers.getMapper(ReserveMapper.class);

    Reserve toEntity(ReserveDto reserveDto);
    ReserveDto toDto(Reserve reserve);
    ReserveIdDto toIdDto(Reserve reserve);
    List<ReserveDto> toListDto(List<Reserve> reserveList);
    List<Reserve> toListEntity(List<ReserveDto> reserveDtoList);
}
