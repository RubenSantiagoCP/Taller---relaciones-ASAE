package com.edu.unicauca.asae.formatoa_relaciones.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "proffesors")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "proffesor_name", length = 100)
    private String name;

    @Column(name = "proffesor_last_name", length = 100)
    private String lastName;

    @Column(name = "proffesor_grouo_name", length = 100)
    private String groupName;


    @Column(name = "proffesor_email", unique = true, length = 100)
    private String email;

    @OneToMany
    private List<HistoricalRecord> historicalRecord;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objProfessor", cascade = {CascadeType.REMOVE})
    private List<AFormat> aFormat;

}
