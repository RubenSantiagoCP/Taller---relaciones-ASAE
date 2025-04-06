package com.edu.unicauca.asae.formatoa_relaciones.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "a_formats")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@SuperBuilder
public class AFormat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formatAId;

    @Column(name= "general_objective", nullable = false)
    private String generalObjective;

    @Column(name = "title", nullable = false, unique = true, length = 200)
    private String title;

    @Column(name = "specific_objective", nullable = false)
    private String specificObjective;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "professorId", nullable = false)
    private Professor objProfessor;

    @OneToOne(mappedBy = "objAformat", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private State state;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objAFormat", cascade = {CascadeType.REMOVE})
    private List<Evaluation> evaluations;

}
