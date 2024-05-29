package com.joaovellenich.TruckLogistic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
public class Trailer {
    private UUID id;
    private Company company;
    private String plate;
    private String description;
    private List<Tire> tires;
    private Truck truck;
}
