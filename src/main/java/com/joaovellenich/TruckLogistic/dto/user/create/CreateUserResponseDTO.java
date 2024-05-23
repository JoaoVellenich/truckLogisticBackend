package com.joaovellenich.TruckLogistic.dto.user.create;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateUserResponseDTO (
        UUID id,
        String name,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){
}
