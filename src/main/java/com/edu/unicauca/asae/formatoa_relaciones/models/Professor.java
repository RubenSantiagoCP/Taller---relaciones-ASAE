package com.edu.unicauca.asae.formatoa_relaciones.models;


import jakarta.persistence.*;

@Entity
@Table(name = "docentes")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
