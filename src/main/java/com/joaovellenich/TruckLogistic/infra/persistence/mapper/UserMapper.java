package com.joaovellenich.TruckLogistic.infra.persistence.mapper;

import com.joaovellenich.TruckLogistic.infra.persistence.entities.UserEntity;
import com.joaovellenich.TruckLogistic.model.User;

public class UserMapper {
    private final CompanyMapper companyMapper;
    public UserMapper(CompanyMapper companyMapper){
        this.companyMapper = companyMapper;
    }
    public UserEntity toEntity(User user){
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .company(this.companyMapper.toEntity(user.getCompany()))
                .role(user.getRole())
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
                .company(this.companyMapper.toDomain(user.getCompany()))
                .role(user.getRole())
                .createAt(user.getCreateAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
