package com.joaovellenich.TruckLogistic.dto.company.listUsers;

import com.joaovellenich.TruckLogistic.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class ListUserDTOMapper {
    public List<ListUserResponseDTO> toResponse(List<User> users){
        return users.stream().map(user -> ListUserResponseDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .role(user.getRole())
                .createdAt(user.getCreateAt())
                .build()
        ).collect(Collectors.toList());
    }
}
