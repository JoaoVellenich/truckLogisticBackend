package com.joaovellenich.TruckLogistic.dto.user.create;

import com.joaovellenich.TruckLogistic.model.UserRole;

public record CreateUserRequestDTO (
         String name,
         String email,
         String password,
         UserRole role
){
}
