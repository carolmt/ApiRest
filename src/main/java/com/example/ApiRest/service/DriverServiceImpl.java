package com.example.ApiRest.service;

import com.example.ApiRest.DTO.DriverDto;
import com.example.ApiRest.mapper.DriverDtoMapper;
import com.example.ApiRest.model.Driver;
import com.example.ApiRest.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService{
    private final DriverRepository driverRepository;
    private final DriverDtoMapper driverDTOMapper;


    @Autowired
    public DriverServiceImpl(DriverRepository repository, DriverDtoMapper driverDTOMapper) {
        this.driverRepository = repository;
        this.driverDTOMapper = driverDTOMapper;
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

    @Override
    public List<DriverDto> getAllDriversDto() {
        return driverRepository.findAll().stream().map(driverDTOMapper).toList();
    }

    @Override
    public Optional<DriverDto> getDriverByCodeDto(String code) {
        return driverRepository.findByCodeIgnoreCaseDto(code);
    }
}
