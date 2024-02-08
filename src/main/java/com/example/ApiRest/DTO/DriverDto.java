package com.example.ApiRest.DTO;

public record DriverDto(
        Long driverId,
        String code,
        String fullname,
        String nationality,
        String constructor
) {
}
