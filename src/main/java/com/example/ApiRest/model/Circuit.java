package com.example.ApiRest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "circuits")
public class Circuit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "circuitid")
    private Long circuitId;

    @Column(unique = true, name = "circuitref")
    private String circuitRef;
    private String name;
    private String location;
    private String country;
    private double lat;
    private double lng;
    private int alt;
    private String url;

    @OneToOne
    @JoinColumn(name = "circuitid")
    private Race race;
}
