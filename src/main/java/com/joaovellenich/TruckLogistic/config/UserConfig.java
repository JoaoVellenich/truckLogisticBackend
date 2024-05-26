package com.joaovellenich.TruckLogistic.config;

import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.application.useCase.user.CreateUserUseCase;
import com.joaovellenich.TruckLogistic.application.useCase.user.LoginUserUseCase;
import com.joaovellenich.TruckLogistic.dto.user.create.CreateUserDTOMapper;
import com.joaovellenich.TruckLogistic.infra.gateways.UserRepositoryGateway;
import com.joaovellenich.TruckLogistic.infra.persistence.mapper.UserMapper;
import com.joaovellenich.TruckLogistic.infra.persistence.repositories.UserRepository;
import com.joaovellenich.TruckLogistic.infra.security.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {
    @Bean
    public CreateUserUseCase createUserUseCase(UserGateway userGateway, PasswordEncoder passwordEncoder){
        return new CreateUserUseCase(userGateway, passwordEncoder);
    }

    @Bean
    public LoginUserUseCase loginUserUseCase(TokenService tokenService, AuthenticationManager authenticationManager, UserGateway userGateway){
        return new LoginUserUseCase(tokenService, authenticationManager, userGateway);
    }

    @Bean
    public UserGateway userGateway(UserRepository userRepository, UserMapper userMapper){
        return new UserRepositoryGateway(userRepository, userMapper);
    }

    @Bean
    public UserMapper userMapper(){
        return new UserMapper();
    }

    @Bean
    public CreateUserDTOMapper createUserDTOMapper(){
        return new CreateUserDTOMapper();
    }

}
