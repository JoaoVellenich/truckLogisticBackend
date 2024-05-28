package com.joaovellenich.TruckLogistic.dto.company.listUsers;

import com.joaovellenich.TruckLogistic.model.UserRole;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record ListUserResponseDTO (
        UUID id,
        String name,
        String email,
        UserRole role,
        LocalDateTime createdAt
){
}
