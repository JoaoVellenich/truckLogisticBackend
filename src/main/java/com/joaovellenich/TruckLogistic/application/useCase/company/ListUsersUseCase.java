package com.joaovellenich.TruckLogistic.application.useCase.company;

import com.joaovellenich.TruckLogistic.application.gateways.CompanyGateway;
import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.model.User;

import java.util.List;
import java.util.UUID;

public class ListUsersUseCase {
    private final UserGateway userGateway;

    public ListUsersUseCase(UserGateway userGateway){
        this.userGateway = userGateway;
    }

    public List<User> execute(UUID companyId, UUID userId) throws Exception{
        User user = this.userGateway.getUserById(userId);
        if(user.getCompany().getId().equals(companyId)){
            List<User> users = this.userGateway.listUserFromCompany(companyId);
            System.out.println(users);
            return users;
        }else {
            throw new Exception("User not allowed to see data from this company");
        }
    }
}
