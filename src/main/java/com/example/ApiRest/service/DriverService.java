package com.example.ApiRest.service;

import com.example.ApiRest.DTO.DriverDto;
import com.example.ApiRest.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    List<Driver> getAllDrivers();
    Optional<Driver> getDriverByCode(String code);
    void saveDriver(Driver driver);
    void deleteDriverByCode(String code);
    List<DriverDto> getAllDriversDto();
    Optional<DriverDto> getDriverByCodeDto(String code);
}
