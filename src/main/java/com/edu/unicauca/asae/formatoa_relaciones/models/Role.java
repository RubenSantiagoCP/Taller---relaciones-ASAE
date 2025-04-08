package com.edu.unicauca.asae.formatoa_relaciones.models;

import java.util.List;

import com.edu.unicauca.asae.formatoa_relaciones.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "assigned_role", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RoleEnum assignedRole;

    @OneToMany(mappedBy = "objRole")
    private List<HistoricalRecord> historicalRecords;
}
