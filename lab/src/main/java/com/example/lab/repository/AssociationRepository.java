package com.example.lab.repository;

import com.example.lab.entity.Association;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssociationRepository extends JpaRepository<Association,Long> {
    Optional<Association> findByName(String name);
}
