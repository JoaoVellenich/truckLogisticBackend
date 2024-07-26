package com.joaovellenich.TruckLogistic.infra.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "fuel")
public class FuelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "truck_id", nullable = false)
    private TruckEntity truck;
    private Double value;
    private Double km;
    private Double trip;
    private Double kmL;
    private Double price;
    private Double liters;

    private String location;
}
