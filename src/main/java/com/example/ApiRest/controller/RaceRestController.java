package com.example.ApiRest.controller;

import com.example.ApiRest.model.Driver;
import com.example.ApiRest.model.Race;
import com.example.ApiRest.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RaceRestController {
    private final RaceService raceService;

    @Autowired
    public RaceRestController(RaceService service) {
        this.raceService = service;
    }

    @GetMapping("/races")
    public ResponseEntity<List<Race>> getAllRaces() {
        return ResponseEntity.ok(raceService.getAllRaces());
    }

    @GetMapping("/races/{raceId}")
    public ResponseEntity<Race> getRaceByID(@PathVariable Long raceId) {
        return this.raceService.getRaceByID(raceId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/races")
    public ResponseEntity<Race> create(@RequestBody Race race) {
        if(race.getRaceId() != null)
            return ResponseEntity.badRequest().build();

        this.raceService.saveRace(race);

        return ResponseEntity.ok(race);
    }
    @PutMapping("/races")
    public ResponseEntity<Race> saveRace(@RequestBody Race race) {
        this.raceService.saveRace(race);
        return ResponseEntity.ok(race);
    }

    @DeleteMapping("/race/{raceId}")
    public ResponseEntity<Race> deleteRaceByID(@PathVariable Long raceId) {
        this.raceService.deleteRaceByID(raceId);
        return ResponseEntity.noContent().build();
    }
}
