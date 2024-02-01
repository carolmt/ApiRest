package com.example.ApiRest.service;
import com.example.ApiRest.model.Circuit;

import java.util.List;
import java.util.Optional;

public interface CircuitService {

    List<Circuit> getAllCircuits();
    Optional<Circuit> getCircuitByCircuitRef(String circuitRef);

    void saveCircuit(Circuit circuit);
    void deleteCircuitByRef(String circuitRef);
}
