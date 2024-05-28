package com.joaovellenich.TruckLogistic.config;

import com.joaovellenich.TruckLogistic.application.gateways.CompanyGateway;
import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.application.useCase.company.CreateCompanyUseCase;
import com.joaovellenich.TruckLogistic.application.useCase.company.ListUsersUseCase;
import com.joaovellenich.TruckLogistic.dto.company.listUsers.ListUserDTOMapper;
import com.joaovellenich.TruckLogistic.infra.controller.CompanyController;
import com.joaovellenich.TruckLogistic.infra.gateways.CompanyRepositoryGateway;
import com.joaovellenich.TruckLogistic.infra.persistence.mapper.CompanyMapper;
import com.joaovellenich.TruckLogistic.infra.persistence.mapper.UserMapper;
import com.joaovellenich.TruckLogistic.infra.persistence.repositories.CompanyRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class CompanyConfig {
    @Bean
    public CreateCompanyUseCase createCompanyUseCase(CompanyGateway companyGateway){
        return new CreateCompanyUseCase(companyGateway);
    }
    @Bean
    public ListUsersUseCase listUsersUseCase(UserGateway userGateway){
        return new ListUsersUseCase(userGateway);
    }
    @Bean
    public CompanyController companyController(CreateCompanyUseCase createCompanyUseCase, ListUsersUseCase listUsersUseCase, ListUserDTOMapper listUserDTOMapper){
        return new CompanyController(createCompanyUseCase, listUsersUseCase, listUserDTOMapper);
    }
    @Bean
    public CompanyGateway companyGateway(CompanyRepository companyRepository, CompanyMapper companyMapper){
        return new CompanyRepositoryGateway(companyRepository, companyMapper);
    }
    @Bean
    public CompanyMapper companyMapper(){
        return new CompanyMapper();
    }
    @Bean
    public ListUserDTOMapper listUserDTOMapper(){
        return new ListUserDTOMapper();
    }
}
