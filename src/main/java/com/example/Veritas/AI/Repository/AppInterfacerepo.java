package com.example.Veritas.AI.Repository;

import com.example.Veritas.AI.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppInterfacerepo extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findByUsername(String username);
}
