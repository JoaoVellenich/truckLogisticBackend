package com.joaovellenich.TruckLogistic.dto.tire.create;

import java.util.UUID;

public record ChangeTireRequestDTO (
        UUID tireId,
        String description
) {
}
