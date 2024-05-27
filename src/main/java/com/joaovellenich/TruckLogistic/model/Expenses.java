package com.joaovellenich.TruckLogistic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
public class Expenses {
    private UUID id;
    private Truck belongsTo;
    private LocalDateTime updatedAt;
    private Double value;
}
