package com.joaovellenich.TruckLogistic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class Tire {
    private UUID id;
    private Truck belongsTo;
    private double km;
}
