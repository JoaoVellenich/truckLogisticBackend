package com.joaovellenich.TruckLogistic.dto.fuel.create;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Builder
public record CreateFuelResponseDTO(
        UUID fuelId,
        LocalDateTime date,
        Double km,
        Double value,
        Double trip,
        Double kmL,
        Double price,
        Double liters,
        String location

) {
}
