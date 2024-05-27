package com.joaovellenich.TruckLogistic.dto.user.create;

import com.joaovellenich.TruckLogistic.model.UserRole;

import java.util.UUID;

public record CreateUserRequestDTO (
         String name,
         String email,
         String password,
         UserRole role,
         UUID companyId
){
}
