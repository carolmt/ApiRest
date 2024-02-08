package com.example.ApiRest.mapper;

import com.example.ApiRest.DTO.DriverDto;
import com.example.ApiRest.model.Driver;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DriverDtoMapper implements Function<Driver, DriverDto> {
    @Override
    public DriverDto apply(Driver driver) {
        return new DriverDto(
                driver.getDriverId(),
                driver.getCode(),
                driver.getForename() + " " + driver.getSurname(),
                driver.getNationality(),
                driver.getConstructor() != null ? driver.getConstructor().getName() : null
        );
    }
}
