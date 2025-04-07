package fr.ensai.running.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ensai.running.model.Athlete;
import fr.ensai.running.service.AthleteService;

@RestController
@RequestMapping("/api")
public class ApiRestController {

    @Autowired
    private AthleteService athleteService;

    /**
     * Get all athletes
     */
    @GetMapping("/athlete")
    public List<Athlete> allAthletes() {

        return athleteService.findAll();
    }

    /**
     * Get an athlete by id
     * @param id The id of the athlete to retrieve
     * @return The athlete if found, or a 404 Not Found response
     */
    @GetMapping("/athlete/{id}")
    public ResponseEntity<Athlete> getAthlete(@PathVariable long id) { // Changed int to long
        Athlete athlete = athleteService.findById(id);
        if (athlete != null) {
            return new ResponseEntity<>(athlete, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete an athlete by id
     * @param id The id of the athlete to delete
     * @return A 204 No Content response if the athlete was deleted successfully,
     * or a 404 Not Found response if the athlete does not exist.
     */
    @DeleteMapping("/athlete/{id}")
    public ResponseEntity<Void> deleteAthlete(@PathVariable long id) { // Changed int to long
        Athlete athlete = athleteService.findById(id);
        if (athlete != null) {
            athleteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Create a new athlete
     * @param athlete The athlete object to create (passed in the request body as JSON)
     * @return A 201 Created response with the newly created athlete in the response body
     */
    @PostMapping("/athlete")
    public ResponseEntity<Athlete> createAthlete(@RequestBody Athlete athlete) {
        Athlete savedAthlete = athleteService.save(athlete);
        return new ResponseEntity<>(savedAthlete, HttpStatus.CREATED);
    }

}
