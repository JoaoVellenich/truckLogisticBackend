package com.joaovellenich.TruckLogistic.dto.user.create;

import com.joaovellenich.TruckLogistic.model.UserRole;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateUserResponseDTO (
        UUID id,
        String name,
        String email,
        UserRole role,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){
}
