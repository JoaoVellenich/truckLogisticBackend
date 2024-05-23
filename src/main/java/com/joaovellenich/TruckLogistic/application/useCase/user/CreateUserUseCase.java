package com.joaovellenich.TruckLogistic.application.useCase.user;

import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CreateUserUseCase {
    private final UserGateway userGateway;
    private final PasswordEncoder encoder;

    public CreateUserUseCase(UserGateway userGateway, PasswordEncoder encoder){
        this.userGateway = userGateway;
        this.encoder = encoder;
    }

    public User execute(User user) throws Exception{
        boolean hasUser = this.userGateway.hasUserWithEmail(user.getEmail());
        if(!hasUser){
            user.setPassword(encoder.encode(user.getPassword()));
            return  this.userGateway.saveUser(user);
        }else{
            throw new Exception("User already exists on database");
        }
    }
}
