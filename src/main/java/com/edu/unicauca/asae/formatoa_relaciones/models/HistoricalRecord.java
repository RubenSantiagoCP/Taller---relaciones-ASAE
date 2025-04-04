package com.edu.unicauca.asae.formatoa_relaciones.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "historical_records")
public class HistoricalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "active")
    private Boolean active;

    @Column(name= "start_date")
    private LocalDate startDate;

    @Column(name= "end_date")
    private LocalDate endDate;

    @ManyToOne
    Professor professor;

    @ManyToOne
    Role role;
}
