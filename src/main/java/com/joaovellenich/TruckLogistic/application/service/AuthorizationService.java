package com.joaovellenich.TruckLogistic.application.service;

import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    private final UserGateway userGateway;
    public AuthorizationService (UserGateway userGateway){
        this.userGateway = userGateway;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userGateway.findByEmail(username);
    }
}
