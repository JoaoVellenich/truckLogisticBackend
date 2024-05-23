package com.joaovellenich.TruckLogistic.application.gateways;

import com.joaovellenich.TruckLogistic.model.User;

public interface UserGateway {
    boolean hasUserWithEmail(String email);
    User saveUser(User user);
}
