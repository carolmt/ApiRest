package com.example.ApiRest.repository;

import com.example.ApiRest.model.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface CircuitRepository extends JpaRepository<Circuit, Long> {

    Optional<Circuit> findByCircuitRefIgnoreCase(String circuitRef);
    Optional<Circuit> getCircuitByCircuitRef(String circuitRef);

    void deleteCircuitByCircuitRef(String circuitRef);

}
