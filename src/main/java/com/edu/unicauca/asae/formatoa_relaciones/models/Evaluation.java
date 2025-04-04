package com.edu.unicauca.asae.formatoa_relaciones.models;

import com.edu.unicauca.asae.formatoa_relaciones.enums.ConceptEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="evaluations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "evaluation_id")
    private Long id;

    @Column(name = "concept")
    @Enumerated(EnumType.STRING)
    private ConceptEnum concept;

    @Column(name= "date_register_concept")
    private LocalDate dateRegisterConcept;

    @Column(name= "coordinator_name")
    private String coordinatorName;

}
