package org.example.airport.model.repositories;

import org.example.airport.model.entities.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReserveRepository extends JpaRepository<Reserve,Long> {
}
