package com.joaovellenich.TruckLogistic.application.gateways;

import com.joaovellenich.TruckLogistic.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface UserGateway {
    boolean hasUserWithEmail(String email);
    UserDetails findByEmail(String email);
    User saveUser(User user);
    User getUserById(UUID id) throws Exception;
}
