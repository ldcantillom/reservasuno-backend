package org.example.airport.model.mapper;

import org.example.airport.model.dtos.AirlaneDto;
import org.example.airport.model.entities.Airlane;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AirlaneMapper {
    AirlaneMapper INSTANCE = Mappers.getMapper(AirlaneMapper.class);
    Airlane toEntity(AirlaneDto airlaneDto);
    AirlaneDto toDto(Airlane airlane);



}
