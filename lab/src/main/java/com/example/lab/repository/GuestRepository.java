package com.example.lab.repository;

import com.example.lab.entity.Guest;
import com.example.lab.enums.GuestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByStatus(GuestStatus status);
}