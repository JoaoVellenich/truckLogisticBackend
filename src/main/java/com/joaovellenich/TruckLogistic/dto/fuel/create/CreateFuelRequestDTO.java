package com.joaovellenich.TruckLogistic.dto.fuel.create;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateFuelRequestDTO(
        UUID truckId,
        LocalDateTime date,
        Double value,
        Double km,
        Double price,
        String location

) {
}
