package com.edu.unicauca.asae.formatoa_relaciones.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tia_formats")
@PrimaryKeyJoinColumn(name = "idTIAFormat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TIAFormat extends AFormat {

    @Column(name = "student1_name", nullable = false)
    private String student1Name;

    @Column(name = "student2_name", nullable = false)
    private String student2Name;
}
