package com.edu.unicauca.asae.formatoa_relaciones.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "proffesors")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "proffesor_name")
    private String name;

    @Column(name = "proffesor_last_name")
    private String lastName;

    @Column(name = "proffesor_grouo_name")
    private String groupName;


    @Column(name = "proffesor_email")
    private String email;

    @OneToMany
    private List<HistoricalRecord> historicalRecord;

    @OneToMany
    private List<AFormat> aFormat;

}
