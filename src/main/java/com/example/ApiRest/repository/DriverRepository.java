package com.example.ApiRest.repository;

import com.example.ApiRest.DTO.DriverDto;
import com.example.ApiRest.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByCodeIgnoreCase(String code);
    void deleteByCode(String code);
    @Query("SELECT d.id as id, d.code as code, d.forename as forename, d.surname as surname, d.constructor.name as constructor FROM Driver d")
    Optional<DriverDto> findByCodeIgnoreCaseDto(String code);

}
