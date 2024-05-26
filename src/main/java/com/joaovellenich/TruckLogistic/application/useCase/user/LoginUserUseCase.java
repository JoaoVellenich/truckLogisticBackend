package com.joaovellenich.TruckLogistic.application.useCase.user;

import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.dto.user.login.LoginUserRequestDTO;
import com.joaovellenich.TruckLogistic.infra.security.TokenService;
import com.joaovellenich.TruckLogistic.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

public class LoginUserUseCase {
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;


    public LoginUserUseCase(TokenService tokenService, AuthenticationManager authenticationManager){
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }
    public String execute(LoginUserRequestDTO data) throws Exception{
       var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
       var auth = this.authenticationManager.authenticate(usernamePassword);

       var token = this.tokenService.generateToken((User) auth.getPrincipal());
        return token;
    }
}
