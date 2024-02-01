package com.example.ApiRest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "constructors")
@Entity
public class Constructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "constructorid")
    private Long constructorId;

    @Column(name = "constructorref", unique = true)
    private String constructorRef;
    private String name;
    private String nationality;
    private String url;

    @OneToMany(mappedBy = "constructor", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("constructor")
    private List<Driver> drivers;
}
