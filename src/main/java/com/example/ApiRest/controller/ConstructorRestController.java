package com.example.ApiRest.controller;

import com.example.ApiRest.model.Constructor;
import com.example.ApiRest.service.ConstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/constructors")
public class ConstructorRestController {

    private final ConstructorService constructorService;

    @Autowired
    public ConstructorRestController(ConstructorService constructorService) {
        this.constructorService = constructorService;
    }

    @GetMapping("")
    public ResponseEntity<List<Constructor>> getAllConstructors() {
        return ResponseEntity.ok(constructorService.getAllConstructors());
    }
    @GetMapping("/{ref}")
    public ResponseEntity<Constructor> getByConstructorRef(@PathVariable String constructorRef) {
        return this.constructorService.getConstructorByConstructorRef(constructorRef)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
