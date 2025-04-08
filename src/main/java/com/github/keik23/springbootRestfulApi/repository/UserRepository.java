package com.github.keik23.springbootRestfulApi.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.github.keik23.springbootRestfulApi.entities.User;

import jakarta.validation.constraints.NotBlank;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Boolean existsByEmail(@NotBlank String email);
}
