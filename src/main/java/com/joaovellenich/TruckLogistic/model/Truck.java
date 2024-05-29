package com.joaovellenich.TruckLogistic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@ToString
public class Truck {
    private UUID id;
    private Company company;
    private String plate;
    private String description;
    private List<Tire> tires;
    private double km;
    private int numberOfAxle;
//    private Trailer trailer;
    private Expenses expenses;
}
