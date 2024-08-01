package com.joaovellenich.TruckLogistic.config;

import com.joaovellenich.TruckLogistic.application.gateways.TireGateway;
import com.joaovellenich.TruckLogistic.application.gateways.TruckGateway;
import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.application.useCase.tire.ChangeTireUseCase;
import com.joaovellenich.TruckLogistic.infra.controller.TireController;
import com.joaovellenich.TruckLogistic.infra.gateways.TireRepositoryGateway;
import com.joaovellenich.TruckLogistic.infra.persistence.mapper.TireMapper;
import com.joaovellenich.TruckLogistic.infra.persistence.repositories.TireRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TireConfig {
    @Bean
    public TireController tireController(ChangeTireUseCase changeTireUseCase){
        return new TireController(changeTireUseCase);
    }
    @Bean
    public ChangeTireUseCase changeTireUseCase(UserGateway userGateway, TireGateway tireGateway, TruckGateway truckGateway){
        return new ChangeTireUseCase(userGateway, tireGateway, truckGateway);
    }
    @Bean
    public TireGateway tireGateway(TireRepository tireRepository, TireMapper tireMapper){
        return new TireRepositoryGateway(tireRepository, tireMapper);
    }
    @Bean
    public TireMapper tireMapper(){return new TireMapper();}
}
