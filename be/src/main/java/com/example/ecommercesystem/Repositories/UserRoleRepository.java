package com.example.ecommercesystem.Repositories;

import com.example.ecommercesystem.Models.User;
import com.example.ecommercesystem.Models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<Optional<UserRole>> findByUser(User user);
}
