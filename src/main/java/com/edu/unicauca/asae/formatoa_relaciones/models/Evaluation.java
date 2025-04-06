package com.edu.unicauca.asae.formatoa_relaciones.models;

import com.edu.unicauca.asae.formatoa_relaciones.enums.ConceptEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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

    @Column(name= "coordinator_name", length = 100)
    private String coordinatorName;

    @ManyToOne
    @JoinColumn(name = "formatAId", nullable = false)
    private AFormat objAFormat;

    @OneToMany(mappedBy = "objEvaluation")
    private List<Observation> observations;

}
