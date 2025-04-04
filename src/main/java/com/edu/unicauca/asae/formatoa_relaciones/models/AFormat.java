package com.edu.unicauca.asae.formatoa_relaciones.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AFormat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formatAId;

    @Column(name= "general_objective")
    private String generalObjective;

    @Column(name = "specific_objective")
    private String specificObjective;

    @ManyToOne
    @JoinColumn(name = "professorId", nullable = false)
    private Professor objProfessor;

}
