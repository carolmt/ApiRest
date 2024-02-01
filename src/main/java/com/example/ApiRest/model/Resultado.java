package com.example.ApiRest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "results")
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resultid")
    private Long resultId;

    private Integer position;
    private int grid;
    private int points;

    @ManyToOne
    @JoinColumn(name = "driverid")
    Driver driver;

    @ManyToOne
    @JoinColumn(name = "raceid")
    Race race;
}
