package org.example.airport.model.repositories;

import org.example.airport.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByUsername(String username);

    Optional<Client> findByEmail(String email);

    boolean existsUserByUsername(String username);

    boolean existsUserByEmail(String email);
}
