package com.joaovellenich.TruckLogistic.application.useCase.user;

import com.joaovellenich.TruckLogistic.application.gateways.CompanyGateway;
import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.dto.user.create.CreateUserRequestDTO;
import com.joaovellenich.TruckLogistic.model.Company;
import com.joaovellenich.TruckLogistic.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

public class CreateUserUseCase {
    private final UserGateway userGateway;
    private final CompanyGateway companyGateway;
    private final PasswordEncoder encoder;

    public CreateUserUseCase(UserGateway userGateway, CompanyGateway companyGateway, PasswordEncoder encoder){
        this.userGateway = userGateway;
        this.companyGateway = companyGateway;
        this.encoder = encoder;
    }

    public User execute(CreateUserRequestDTO user) throws Exception{
        Company userCompany = this.companyGateway.findById(user.companyId());
        if(userCompany == null){
            throw new Exception("Company not found");
        }
        boolean hasUser = this.userGateway.hasUserWithEmail(user.email());
        if(!hasUser){
            User newUser = User.builder()
                    .name(user.name())
                    .email(user.email())
                    .password(this.encoder.encode(user.password()))
                    .company(userCompany)
                    .role(user.role())
                    .build();

            return this.userGateway.saveUser(newUser);
        }else{
            throw new Exception("User already exists on database");
        }
    }
}
