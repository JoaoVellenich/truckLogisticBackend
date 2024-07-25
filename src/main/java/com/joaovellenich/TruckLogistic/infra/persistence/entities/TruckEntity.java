package com.joaovellenich.TruckLogistic.infra.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "trucks")
public class TruckEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyEntity company;
    @Column(nullable = false, unique = false)
    private String plate;
    private String description;
    @Column(nullable = false)
    private double km;
    @Column(nullable = false)
    private int numberOfAxle;
}
