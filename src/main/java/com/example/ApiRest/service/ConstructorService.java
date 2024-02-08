package com.example.ApiRest.service;

import com.example.ApiRest.model.Constructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface ConstructorService {
    Optional<Constructor> getDriverByConstructorId(Long constructorId);
    Constructor saveConstructor(Constructor constructor);
    List<Constructor> getAllConstructors();
    Optional<Constructor> getConstructorByConstructorRef(String constructorRef);

}
