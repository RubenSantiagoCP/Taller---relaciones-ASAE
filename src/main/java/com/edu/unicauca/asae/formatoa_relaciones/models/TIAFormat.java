package com.edu.unicauca.asae.formatoa_relaciones.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "idTIAFormat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TIAFormat {

    @Column(name = "student1_name")
    private String student1Name;

    @Column(name = "student2_name")
    private String student2Name;
}
