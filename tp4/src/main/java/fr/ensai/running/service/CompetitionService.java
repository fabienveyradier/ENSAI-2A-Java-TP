package fr.ensai.running.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ensai.running.model.Competition;
import fr.ensai.running.repository.CompetitionRepository;

@Service
public class CompetitionService {
    
    @Autowired
    private CompetitionRepository competitionRepository;
    
    /**
     * Find all competitions
     * @return List of all competitions
     */
    public List<Competition> findAll() {
        return competitionRepository.findAll();
    }
    
    /**
     * Find a competition by its ID
     * @param id The competition ID
     * @return The competition if found, null otherwise
     */
    public Competition findById(Long id) {
        Optional<Competition> competition = competitionRepository.findById(id);
        return competition.orElse(null);
    }
    
    /**
     * Delete a competition by its ID
     * @param id The competition ID
     */
    public void deleteById(Long id) {
        competitionRepository.deleteById(id);
    }
    
    /**
     * Save a competition (create or update)
     * @param competition The competition to save
     * @return The saved competition
     */
    public Competition save(Competition competition) {
        return competitionRepository.save(competition);
    }
}