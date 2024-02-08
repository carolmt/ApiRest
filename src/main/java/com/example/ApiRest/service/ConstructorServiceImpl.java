package com.example.ApiRest.service;

import com.example.ApiRest.model.Constructor;
import com.example.ApiRest.repository.ConstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstructorServiceImpl implements ConstructorService {

    private final ConstructorRepository repository;
    @Autowired
    public ConstructorServiceImpl(ConstructorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Constructor> getConstructorByConstructorRef(String constructorRef) {
        return repository.findByConstructorRefIgnoreCase(constructorRef);
    }
    @Override
    public Optional<Constructor> getDriverByConstructorId(Long constructorId) {
        return repository.findById(constructorId);
    }

    @Override
    public Constructor saveConstructor(Constructor constructor) {
        return this.repository.save(constructor);
    }

    @Override
    public List<Constructor> getAllConstructors() {
        return repository.findAll();
    }


}
