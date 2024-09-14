package org.example.airport.model.repositories;

import org.example.airport.model.entities.Airlane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlaneRepository extends JpaRepository<Airlane,Long> {
}
