package fr.ensai.running.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ensai.running.model.Competition;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    
    // Find competitions by city
    List<Competition> findByCity(String city);
    
    // Find competitions occurring after a specific date
    List<Competition> findByEventDateAfter(LocalDate date);
    
    // Find competitions by distance range
    List<Competition> findByDistanceBetween(Double minDistance, Double maxDistance);
    
    // Find competitions with available slots
    List<Competition> findByMaxAthletesGreaterThan(Integer enrolledAthletes);
}
