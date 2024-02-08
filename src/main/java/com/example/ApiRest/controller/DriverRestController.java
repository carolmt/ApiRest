package com.example.ApiRest.controller;

import com.example.ApiRest.DTO.DriverDto;
import com.example.ApiRest.model.Driver;
import com.example.ApiRest.proyeccion.DriverInfo;
import com.example.ApiRest.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverRestController {
    private final DriverService driverService;

    @Autowired
    public DriverRestController(DriverService service) {
        this.driverService = service;
    }

    @GetMapping("")
    public ResponseEntity<List<DriverInfo>> getAllgetAllPagedAndSorted(@RequestParam(defaultValue = "0") int page,
                                                                       @RequestParam(defaultValue = "5") int size,
                                                                       @RequestParam(defaultValue = "code") String sortBy,
                                                                       @RequestParam(defaultValue = "ASC") String sortDirection) {
        Page<DriverInfo> driversPage = this.driverService.getAllDriversPaged(page, size, sortBy, sortDirection);
        return ResponseEntity.ok(driversPage.getContent());
    }
    @GetMapping("/{code}")
    public ResponseEntity<DriverInfo> getDriverByCode(@PathVariable String code) {
        return this.driverService.getDriverByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/drivers")
    public ResponseEntity<Driver> create(@RequestBody Driver driver) {
        if (driver.getDriverId() != null)
            return ResponseEntity.badRequest().build();

        this.driverService.saveDriver(driver);

        return ResponseEntity.ok(driver);
    }

    @PutMapping("/drivers")
    public ResponseEntity<Driver> update(@RequestBody Driver driver) {
        this.driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);
    }

    @DeleteMapping("/drivers/{code}")
    public ResponseEntity<Driver> update(@PathVariable String code) {
        this.driverService.deleteDriverByCode(code);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/driversDTO/{code}")
    public ResponseEntity<DriverDto> getDriverByCodeDto(@PathVariable String code) {
        return this.driverService.getDriverByCodeDto(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/driversDTO")
    public ResponseEntity<List<DriverDto>> getAllDriversDto() {
        return ResponseEntity.ok(driverService.getAllDriversDto());
    }
}
