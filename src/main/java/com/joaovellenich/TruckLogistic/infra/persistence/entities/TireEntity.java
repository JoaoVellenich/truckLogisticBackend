package com.joaovellenich.TruckLogistic.infra.persistence.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
@Entity(name = "tires")
public class TireEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private double km;
    @Column(nullable = false)
    private int position;
    @Column(nullable = false)
    private UUID belongsTo;
}
