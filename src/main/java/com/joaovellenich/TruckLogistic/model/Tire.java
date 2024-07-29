package com.joaovellenich.TruckLogistic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Builder
@Getter
@Setter
@ToString
public class Tire {
    private UUID id;
    private double km;
    private int position;
    private UUID belongsTo;
    private boolean isActive;
}
