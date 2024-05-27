package com.joaovellenich.TruckLogistic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
public class Truck {
    private UUID id;
    private String plate;
    private String description;
    private double km;
    private List<Tire> tires;
    private Trailer trailer;
    private Expenses expenses;
}
