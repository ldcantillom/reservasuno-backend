package org.example.airport.model.repositories;
import org.example.airport.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Collection;

public interface ClientRepository extends JpaRepository<Client,Long> {
    List<Client> findByName(String name);
    List<Client> findByIdIn(Collection<Long> ids);
}
