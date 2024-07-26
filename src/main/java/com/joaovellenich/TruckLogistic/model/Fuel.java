package com.joaovellenich.TruckLogistic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@ToString
public class Fuel {
    private UUID id;
    private LocalDateTime date;
    private Truck truck;

    private Double value;
    private Double km;
    private Double trip;
    private Double kmL;
    private Double price;
    private Double liters;

    private String location;
}
