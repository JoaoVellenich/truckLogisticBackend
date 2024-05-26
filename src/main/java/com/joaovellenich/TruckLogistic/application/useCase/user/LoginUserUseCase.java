package com.joaovellenich.TruckLogistic.application.useCase.user;

import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.dto.user.login.LoginUserRequestDTO;
import com.joaovellenich.TruckLogistic.infra.persistence.entities.UserEntity;
import com.joaovellenich.TruckLogistic.infra.security.TokenService;
import com.joaovellenich.TruckLogistic.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

public class LoginUserUseCase {
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final UserGateway userGateway;

    public LoginUserUseCase(TokenService tokenService, AuthenticationManager authenticationManager, UserGateway userGateway){
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.userGateway = userGateway;
    }
    public String execute(LoginUserRequestDTO data) throws Exception{
       var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
       var auth = this.authenticationManager.authenticate(usernamePassword);
       var userEntity = (UserEntity) auth.getPrincipal();
       var user = this.userGateway.getUserById(userEntity.getId());
        return this.tokenService.generateToken(user);
    }
}
