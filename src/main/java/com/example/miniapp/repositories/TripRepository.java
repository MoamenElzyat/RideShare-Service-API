package com.example.miniapp.repositories;

import com.example.miniapp.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByTripDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Trip> findByCaptainId(Long captainId);
}
