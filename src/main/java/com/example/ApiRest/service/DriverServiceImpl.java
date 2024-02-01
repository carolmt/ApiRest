package com.example.ApiRest.service;

import com.example.ApiRest.model.Driver;
import com.example.ApiRest.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService{
    private final DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository repository) {
        this.driverRepository = repository;
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Optional<Driver> getDriverByCode(String code) {
        return driverRepository.findByCodeIgnoreCase(code);
    }

    @Override
    public void saveDriver(Driver driver) {
        driverRepository.save(driver);
    }
    @Override
    public void deleteDriverByCode(String code) {
        driverRepository.deleteByCode(code);
    }
}
