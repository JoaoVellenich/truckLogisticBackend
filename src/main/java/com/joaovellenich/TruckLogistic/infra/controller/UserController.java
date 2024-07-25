package com.joaovellenich.TruckLogistic.infra.controller;

import com.joaovellenich.TruckLogistic.application.gateways.CompanyGateway;
import com.joaovellenich.TruckLogistic.application.useCase.user.CreateUserUseCase;
import com.joaovellenich.TruckLogistic.application.useCase.user.LoginUserUseCase;
import com.joaovellenich.TruckLogistic.dto.user.create.CreateUserDTOMapper;
import com.joaovellenich.TruckLogistic.dto.user.create.CreateUserRequestDTO;
import com.joaovellenich.TruckLogistic.dto.user.login.LoginUserRequestDTO;
import com.joaovellenich.TruckLogistic.infra.security.TokenService;
import com.joaovellenich.TruckLogistic.model.Company;
import com.joaovellenich.TruckLogistic.model.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity createUser(@RequestBody CreateUserRequestDTO user){
        try{
            User createdUser = this.createUserUseCase.execute(user);
            return ResponseEntity.ok().body(this.createUserDTOMapper.toResponse(createdUser));
        }catch (Exception error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity login(@RequestBody LoginUserRequestDTO user, HttpServletResponse response){
        try{
            var token = this.loginUserUseCase.execute(user);
            Cookie cookie = new Cookie("jwt", token);
            cookie.setHttpOnly(true);
            cookie.setSecure(false);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 2);

            response.addCookie(cookie);

            return ResponseEntity.ok().body("Welcome");
        }catch (Exception error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @GetMapping("/check")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity checkAuth(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            return ResponseEntity.ok().body("Authenticated");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not Authenticated");
        }
    }
}
