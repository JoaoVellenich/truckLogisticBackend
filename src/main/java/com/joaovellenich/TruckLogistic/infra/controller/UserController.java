package com.joaovellenich.TruckLogistic.infra.controller;

import com.joaovellenich.TruckLogistic.application.useCase.user.CreateUserUseCase;
import com.joaovellenich.TruckLogistic.dto.user.create.CreateUserDTOMapper;
import com.joaovellenich.TruckLogistic.dto.user.create.CreateUserRequestDTO;
import com.joaovellenich.TruckLogistic.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final CreateUserDTOMapper createUserDTOMapper;

    public UserController(CreateUserUseCase createUserUseCase, CreateUserDTOMapper createUserDTOMapper){
        this.createUserUseCase = createUserUseCase;
        this.createUserDTOMapper = createUserDTOMapper;
    }

    @PostMapping("/")
    public ResponseEntity createUser(@RequestBody CreateUserRequestDTO user){
        User userToCreate = this.createUserDTOMapper.toDomain(user);
        try{
            User createdUser = this.createUserUseCase.execute(userToCreate);
            return ResponseEntity.ok().body(this.createUserDTOMapper.toResponse(createdUser));
        }catch (Exception error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
}
