package com.edu.unicauca.asae.formatoa_relaciones.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "historical_records")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoricalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "active", nullable = false)
    private Boolean active;

    @Column(name= "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name= "end_date", nullable = false)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "professorid", nullable = false)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "rolId",nullable = false)
    private Role objRole;
}
