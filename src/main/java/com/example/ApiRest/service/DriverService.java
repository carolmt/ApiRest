package com.example.ApiRest.service;

import com.example.ApiRest.DTO.DriverDto;
import com.example.ApiRest.model.Driver;
import com.example.ApiRest.proyeccion.DriverInfo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    Optional<DriverInfo> getDriverByCode(String code);
    void saveDriver(Driver driver);
    void deleteDriverByCode(String code);
    List<DriverDto> getAllDriversDto();
    Optional<DriverDto> getDriverByCodeDto(String code);
    Page<DriverInfo> getAllDriversPaged(int pageNo, int pageSize, String sortBy, String sortDirection);

}
