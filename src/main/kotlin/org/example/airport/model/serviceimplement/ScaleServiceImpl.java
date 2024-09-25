package org.example.airport.model.serviceimplement;

import org.example.airport.model.entities.Airport;
import org.example.airport.model.entities.Scale;
import org.example.airport.model.repositories.ScaleRepository;
import org.example.airport.model.services.ScaleService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScaleServiceImpl implements ScaleService {
    public ScaleServiceImpl(ScaleRepository scaleRepository) {
        this.scaleRepository = scaleRepository;
    }
    private ScaleRepository scaleRepository;

    @Override
    public Scale save(Scale scale) {
        return scaleRepository.save(scale);
    }

    @Override
    public Optional<Scale> getById(Long id) {
        return scaleRepository.findById(id);
    }

    @Override
    public List<Scale> getAllScales() {
        return scaleRepository.findAll();
    }

    @Override
    public List<Scale> getAllScalesByName(String name) {
        Scale scale = new Scale();
        scale.setName(name);
        Example<Scale> example = Example.of(scale);
        return scaleRepository.findAll(example);
    }

    @Override
    public List<Scale> getAllScalesByAirportOrigin(Airport airport) {
        Scale scale = new Scale();
        scale.setAirport(airport);
        Example<Scale> example = Example.of(scale);
        return scaleRepository.findAll(example);
    }

    @Override
    public Optional<Scale> updateScale(Long id, Scale scale) {
        return scaleRepository.findById(id).map(oldScale -> {
            oldScale.setName(scale.getName());
            oldScale.setScaleTime(scale.getScaleTime());
            oldScale.setAirport(scale.getAirport());
            oldScale.setFlights(scale.getFlights());
            return scaleRepository.save(oldScale);
        });
    }

    @Override
    public void deleteScale(Long id) {
        scaleRepository.deleteById(id);
    }
}
