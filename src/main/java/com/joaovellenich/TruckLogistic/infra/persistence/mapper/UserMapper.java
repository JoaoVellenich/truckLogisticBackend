package com.joaovellenich.TruckLogistic.infra.persistence.mapper;

import com.joaovellenich.TruckLogistic.infra.persistence.entities.UserEntity;
import com.joaovellenich.TruckLogistic.model.User;

public class UserMapper {
    public UserEntity toEntity(User user){
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .createAt(user.getCreateAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    public User toDomain(UserEntity user){
        return User.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .createAt(user.getCreateAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
