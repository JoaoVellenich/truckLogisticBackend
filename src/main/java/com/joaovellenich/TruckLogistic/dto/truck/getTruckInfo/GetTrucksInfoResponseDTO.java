package com.joaovellenich.TruckLogistic.dto.truck.getTruckInfo;

import lombok.Builder;

import java.util.UUID;

@Builder
public record GetTrucksInfoResponseDTO(
        UUID id,
        String plate,
        String description,
        double km
) {
}
