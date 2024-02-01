package com.example.ApiRest.service;

import com.example.ApiRest.model.Race;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface RaceService {

    List<Race> getAllRaces();

    Optional<Race> getRaceByID(Long raceId);

    void saveRace(Race race);

    void deleteRaceByID(Long raceId);
}
