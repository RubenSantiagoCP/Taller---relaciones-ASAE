package com.edu.unicauca.asae.formatoa_relaciones.models;

import java.time.LocalDate;

import com.edu.unicauca.asae.formatoa_relaciones.enums.StateEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "states")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateId;

    @Column(name = "actual_state")
    @Enumerated(EnumType.STRING)
    private StateEnum actualState;

    @Column(name = "register_state_date")
    private LocalDate registerStateDate;

    @OneToOne
    @JoinColumn(name = "formatAId", unique = true)
    private AFormat objAformat;
}
