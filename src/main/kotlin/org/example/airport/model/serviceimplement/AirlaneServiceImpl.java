package org.example.airport.model.serviceimplement;
import org.example.airport.model.repositories.AirlaneRepository;
import org.example.airport.model.entities.Airlane;
import org.example.airport.model.services.AirlaneService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlaneServiceImpl implements AirlaneService {
    public AirlaneServiceImpl(AirlaneRepository airlaneRepository) {
        this.airlaneRepository=airlaneRepository;
    }
    private AirlaneRepository airlaneRepository;

    @Override
    public Airlane saveAirlane(Airlane airlane) {
        return airlaneRepository.save(airlane);
    }

    @Override
    public Optional<Airlane> findAirlaneById(Long id) {
        return airlaneRepository.findById(id);
    }

    @Override
    public List<Airlane> findAllAirlanes() {
        return airlaneRepository.findAll();
    }

    @Override
    public List<Airlane> findAllAirlanesByIds(List<Long> ids) {
        return airlaneRepository.findAllById(ids);
    }

    @Override
    public List<Airlane> findAllAirlanesByName(String airportName) {
        Airlane a = new Airlane() ;
        a.setName(airportName);
        Example<Airlane> example = Example.of(a);
        return airlaneRepository.findAll(Example.of(a));
    }


    @Override
    public List<Airlane> findAllAirlanesByCountry(String country) {
        Airlane a = new Airlane();
        a.setOrigin_country(country);
        Example<Airlane> example= Example.of(a);
        return airlaneRepository.findAll(Example.of(a));
    }

    @Override
    public Optional<Airlane> updateAirlane(Long id, Airlane airpAirlane) {
        return airlaneRepository.findById(id).map(oldAirlane -> {
            oldAirlane.setName(airpAirlane.getName());
            oldAirlane.setOrigin_country(airpAirlane.getOrigin_country());
            oldAirlane.setFlights(airpAirlane.getFlights());
            oldAirlane.setAirlane_code(airpAirlane.getAirlane_code());
            return airlaneRepository.save(oldAirlane);
        });
    }

    @Override
    public void deleteAirlane(Long id) {
        airlaneRepository.deleteById(id);

    }
}
