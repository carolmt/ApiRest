package com.example.ApiRest.service;

import com.example.ApiRest.model.Circuit;
import com.example.ApiRest.repository.CircuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CircuitServiceImpl implements CircuitService{
    private final CircuitRepository circuitRepository;

    @Autowired
    public CircuitServiceImpl(CircuitRepository circuitRepository) {
        this.circuitRepository = circuitRepository;
    }

    @Override
    public List<Circuit> getAllCircuits() {
        return circuitRepository.findAll();
    }

    @Override
    public Optional<Circuit> getCircuitByCircuitRef(String circuitRef) {
        if (circuitRef == null) {
            throw new IllegalArgumentException("circuitRef no puede ser null");
        }
        return circuitRepository.findByCircuitRefIgnoreCase(circuitRef);
    }

    @Override
    public void saveCircuit(Circuit circuit) {
        circuitRepository.save(circuit);
    }

    @Override
    public void deleteCircuitByRef(String circuitRef) {
        circuitRepository.deleteCircuitByCircuitRef(circuitRef);
    }
}
