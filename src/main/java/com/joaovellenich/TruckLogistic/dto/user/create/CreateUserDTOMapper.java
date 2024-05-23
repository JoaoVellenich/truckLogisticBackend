package com.joaovellenich.TruckLogistic.dto.user.create;

import com.joaovellenich.TruckLogistic.model.User;

public class CreateUserDTOMapper {
    public User toDomain(CreateUserRequestDTO user){
        return User.builder()
                .name(user.name())
                .email(user.email())
                .password(user.password())
                .build();
    }

    public CreateUserResponseDTO toResponse(User user){
        return new CreateUserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getCreateAt(), user.getUpdatedAt());
    }
}
