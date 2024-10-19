package org.example.airport.model.repositories;

import org.example.airport.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

    Optional<User> findByEmail(String email);

    boolean existsUserByUserName(String username);

    boolean existsUserByEmail(String email);
}
