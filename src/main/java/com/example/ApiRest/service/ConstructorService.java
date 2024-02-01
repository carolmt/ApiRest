package com.example.ApiRest.service;

import com.example.ApiRest.model.Constructor;
import com.example.ApiRest.model.Driver;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ConstructorService {
    ResponseEntity<List<Constructor>> getAllConstructors();
    Optional<Constructor> getDriverById(Long constructorId);
    Constructor saveConstructor(Constructor constructor);

}
