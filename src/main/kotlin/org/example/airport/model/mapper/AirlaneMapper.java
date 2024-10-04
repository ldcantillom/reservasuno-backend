package org.example.airport.model.mapper;

import lombok.AllArgsConstructor;
import org.example.airport.model.dtos.AirlaneDto;
import org.example.airport.model.entities.Airlane;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AirlaneMapper {
    private FlightMapper flightMapper;
    public Airlane toEntity(AirlaneDto airlaneDto) {
        Airlane airlane = new Airlane();
        airlane.setName(airlaneDto.name());
        airlane.setAirlaneCode(airlaneDto.airlane_code());
        airlane.setOriginCountry(airlaneDto.origin_country());
        airlane.setFlights(flightMapper.toListEntity(airlaneDto.flights()));
        return airlane;
    }
    public AirlaneDto toDto(Airlane airlane) {
        AirlaneDto airlaneDto = new AirlaneDto(
            airlane.getName(),
            airlane.getAirlaneCode(),
            airlane.getOriginCountry(),
            flightMapper.toListDto(airlane.getFlights())
        );
        return airlaneDto;
    }



}
