package com.example.ecommercesystem.Repositories;

import com.example.ecommercesystem.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String username);
    Optional<User> findById(Long id);
}
