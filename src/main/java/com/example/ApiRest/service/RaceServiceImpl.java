package com.example.ApiRest.service;

import com.example.ApiRest.model.Race;
import com.example.ApiRest.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaceServiceImpl implements RaceService {
    private final RaceRepository raceRepository;

    @Autowired
    public RaceServiceImpl(RaceRepository repository) {
        this.raceRepository = repository;
    }

    @Override
    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    @Override
    public Optional<Race> getRaceByID(Long raceId) {
        return raceRepository.findById(raceId);
    }
    @Override
    public void saveRace(Race race) {
        raceRepository.save(race);
    }
    @Override
    public void deleteRaceByID(Long raceId) {
        raceRepository.deleteById(raceId);
    }
}
