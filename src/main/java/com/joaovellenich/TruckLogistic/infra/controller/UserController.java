package com.joaovellenich.TruckLogistic.infra.controller;

import com.joaovellenich.TruckLogistic.application.useCase.user.CreateUserUseCase;
import com.joaovellenich.TruckLogistic.application.useCase.user.LoginUserUseCase;
import com.joaovellenich.TruckLogistic.dto.user.create.CreateUserDTOMapper;
import com.joaovellenich.TruckLogistic.dto.user.create.CreateUserRequestDTO;
import com.joaovellenich.TruckLogistic.dto.user.login.LoginUserRequestDTO;
import com.joaovellenich.TruckLogistic.infra.security.TokenService;
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
    private final LoginUserUseCase loginUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase, CreateUserDTOMapper createUserDTOMapper, LoginUserUseCase loginUserUseCase){
        this.createUserUseCase = createUserUseCase;
        this.createUserDTOMapper = createUserDTOMapper;
        this.loginUserUseCase = loginUserUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity createUser(@RequestBody CreateUserRequestDTO user){
        User userToCreate = this.createUserDTOMapper.toDomain(user);
        try{
            User createdUser = this.createUserUseCase.execute(userToCreate);
            return ResponseEntity.ok().body(this.createUserDTOMapper.toResponse(createdUser));
        }catch (Exception error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginUserRequestDTO user){
        try{
            var token = this.loginUserUseCase.execute(user);
            return ResponseEntity.ok().body(token);
        }catch (Exception error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
}
