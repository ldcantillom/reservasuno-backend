package org.example.airport.model.repositories;
import org.example.airport.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Collection;

public interface ClienteRepository extends JpaRepository<Client,Long> {
    List<Client> findByNombre(String nombre);
    List<Client> findByIdIn(Collection<Long> ids);
}
