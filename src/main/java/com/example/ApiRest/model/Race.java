package com.example.ApiRest.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "races")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "raceid")
    private Long raceId;

    private int year;
    private int round;

    @Column(name = "circuitid")
    private String circuitId;
    private String name;
    private LocalDate date;
    private Time time;
    private String url;

    @OneToOne(mappedBy ="race")
    private Circuit circuit;

    @OneToMany(mappedBy = "race")
    private Set<Resultado> resultados;
}
