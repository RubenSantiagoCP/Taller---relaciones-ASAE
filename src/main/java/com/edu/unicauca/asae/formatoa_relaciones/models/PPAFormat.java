package com.edu.unicauca.asae.formatoa_relaciones.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "idPPAFormat")
@Getter
@Setter
@NoArgsConstructor
public class PPAFormat extends AFormat {

    @Column(name = "assesor_name")
    private String assesorName;

    @Column(name="studedt1_name")
    private String studedt1Name;

    @Column(name="acceptance_letter_route")
    private String acceptanceLetterRoute;
}
