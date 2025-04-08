package com.edu.unicauca.asae.formatoa_relaciones.models;

import java.time.LocalDate;

import com.edu.unicauca.asae.formatoa_relaciones.enums.StateEnum;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "states")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateId;

    @Column(name = "actual_state", nullable = false)
    @Enumerated(EnumType.STRING)
    private StateEnum actualState;

    @Column(name = "register_state_date", nullable = false)
    private LocalDate registerStateDate;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "formatAId", unique = true)
    private AFormat objAformat;
}
