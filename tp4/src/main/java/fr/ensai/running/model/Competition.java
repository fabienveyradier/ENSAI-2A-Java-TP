package fr.ensai.running.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "competition")
public class Competition {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_competition")
    private Long idCompetition;
    
    @Column(name = "designation")
    private String designation;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "event_date")
    private LocalDate eventDate;
    
    @Column(name = "distance")
    private Double distance;
    
    @Column(name = "max_athletes")
    private Integer maxAthletes;
    
    // Default constructor
    public Competition() {
    }
    
    // Constructor with parameters
    public Competition(String designation, String city, LocalDate eventDate, Double distance, Integer maxAthletes) {
        this.designation = designation;
        this.city = city;
        this.eventDate = eventDate;
        this.distance = distance;
        this.maxAthletes = maxAthletes;
    }
    
    // Getters and Setters
    public Long getIdCompetition() {
        return idCompetition;
    }
    
    public void setIdCompetition(Long idCompetition) {
        this.idCompetition = idCompetition;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public LocalDate getEventDate() {
        return eventDate;
    }
    
    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
    
    public Double getDistance() {
        return distance;
    }
    
    public void setDistance(Double distance) {
        this.distance = distance;
    }
    
    public Integer getMaxAthletes() {
        return maxAthletes;
    }
    
    public void setMaxAthletes(Integer maxAthletes) {
        this.maxAthletes = maxAthletes;
    }
    
    @Override
    public String toString() {
        return "Competition [idCompetition=" + idCompetition + 
               ", designation=" + designation + 
               ", city=" + city + 
               ", eventDate=" + eventDate + 
               ", distance=" + distance + 
               ", maxAthletes=" + maxAthletes + "]";
    }
}