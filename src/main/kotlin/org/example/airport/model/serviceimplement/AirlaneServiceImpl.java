package org.example.airport.model.serviceimplement;
import lombok.AllArgsConstructor;
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

    @Override
    public Airlane saveAirlane(Airlane airlane) {
        return airlaneRepository.save(airlane);
    }

    @Override
    public Optional<Airlane> getAirlaneById(Long id) {
        return airlaneRepository.findById(id);
    }

    @Override
    public List<Airlane> getAllAirlanes() {
        return airlaneRepository.findAll();
    }

    @Override
    public List<Airlane> getAllAirlanesByIds(List<Long> ids) {
        return airlaneRepository.findAllById(ids);
    }

    @Override
    public List<Airlane> getAllAirlanesByName(String airportName) {
        Airlane a = new Airlane() ;
        a.setName(airportName);
        Example<Airlane> example = Example.of(a);
        return airlaneRepository.findAll(Example.of(a));
    }


    @Override
    public List<Airlane> getAllAirlanesByCountry(String country) {
        Airlane a = new Airlane();
        a.setOriginCountry(country);
        Example<Airlane> example= Example.of(a);
        return airlaneRepository.findAll(Example.of(a));
    }

    @Override
    public Optional<Airlane> updateAirlane(Long id, Airlane airpAirlane) {
        return airlaneRepository.findById(id).map(oldAirlane -> {
            oldAirlane.setName(airpAirlane.getName());
            oldAirlane.setOriginCountry(airpAirlane.getOriginCountry());
            oldAirlane.setFlights(airpAirlane.getFlights());
            oldAirlane.setAirlaneCode(airpAirlane.getAirlaneCode());
            return airlaneRepository.save(oldAirlane);
        });
    }

    @Override
    public void deleteAirlane(Long id) {
        airlaneRepository.deleteById(id);

    }
}
