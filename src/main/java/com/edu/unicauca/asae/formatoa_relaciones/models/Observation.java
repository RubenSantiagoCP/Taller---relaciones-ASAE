package com.edu.unicauca.asae.formatoa_relaciones.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="observations")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Observation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long observationId;

    @Column(name = "observation")
    private String observation;

    @Column(name = "observation_date_register")
    private LocalDate observationDateRegister;

    @ManyToMany
    @JoinTable(name = "proffesor_observation",
            joinColumns = @JoinColumn(name = "observation_id"),
            inverseJoinColumns = @JoinColumn(name = "proffesor_id"))
    private List<Professor> proffesors;
}
