package org.example.airport.model.serviceimplement;
import lombok.AllArgsConstructor;
import org.example.airport.model.dtos.AirlaneDto;
import org.example.airport.model.mapper.AirlaneMapper;
import org.example.airport.model.mapper.FlightMapper;
import org.example.airport.model.repositories.AirlaneRepository;
import org.example.airport.model.entities.Airlane;
import org.example.airport.model.services.AirlaneService;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Lazy))
public class AirlaneServiceImpl implements AirlaneService {
    private AirlaneRepository airlaneRepository;
    private AirlaneMapper airlaneMapper;
    private FlightMapper flightMapper;

    @Override
    public AirlaneDto save(AirlaneDto airlane) {
        return airlaneMapper.toIdDto(airlaneRepository.save(airlaneMapper.toEntity(airlane)));
    }

    @Override
    public Optional<AirlaneDto> findById(int id) {
        return airlaneRepository.findById((long) id).map(airlaneMapper::toIdDto);
    }

    @Override
    public Optional<AirlaneDto> update(int id, AirlaneDto airlane) {
        return airlaneRepository.findById((long) id).map(oldAirline -> {
            oldAirline.setAirlaneCode(airlane.airlaneCode());
            oldAirline.setName(airlane.name());
            oldAirline.setOriginCountry(airlane.originCountry());
            oldAirline.setFlights(flightMapper.toListEntity(airlane.flights()));
            return airlaneMapper.toIdDto(airlaneRepository.save(oldAirline));
        });
    }

    @Override
    public List<AirlaneDto> findAll() {
        return airlaneMapper.toListIdDto(airlaneRepository.findAll());
    }

    @Override
    public List<AirlaneDto> findByName(String name) {
        Airlane a = new Airlane();
        a.setName(name);
        Example<Airlane> example = Example.of(a);
        return airlaneMapper.toListIdDto(airlaneRepository.findAll(example));
    }

    @Override
    public void deleteById(int id) {
        airlaneRepository.deleteById((long) id);
    }
}
