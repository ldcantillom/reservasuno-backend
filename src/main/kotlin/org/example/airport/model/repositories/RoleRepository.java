package org.example.airport.model.repositories;

import org.example.airport.model.entities.ERole;
import org.example.airport.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole ERol);
}
