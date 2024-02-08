package com.example.ApiRest.proyeccion;

import org.springframework.beans.factory.annotation.Value;

    public interface DriverInfoDTO {
        Long getId();
        String getCode();

        // Dentro de la anotación “@Value” se utiliza Spring Expression Language(SpEL)
        @Value("#{target.forename + ' ' + target.surname}")
        String getFullname();
    }