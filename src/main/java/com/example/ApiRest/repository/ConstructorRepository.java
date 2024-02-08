package com.example.ApiRest.repository;

import com.example.ApiRest.model.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConstructorRepository extends JpaRepository<Constructor, Long> {

    Optional<Constructor> findByConstructorRefIgnoreCase(String constructorRef);
    void deleteByConstructorRefIgnoreCase(String constructorRef);
}
