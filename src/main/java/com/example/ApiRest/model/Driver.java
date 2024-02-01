package com.example.ApiRest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driverid")
    private Long driverId;

    @Column(unique = true)
    private String code;
    private String forename;
    private String surname;
    @JsonProperty("dateOfBirth")
    private LocalDate dob;
    private String nationality;
    private String url;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "constructorid")
    @JsonIgnoreProperties("drivers")
    private Constructor constructor;

    @OneToMany(mappedBy = "driver")
    private Set<Resultado> resultados;

}
