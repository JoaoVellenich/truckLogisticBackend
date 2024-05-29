package com.joaovellenich.TruckLogistic.config;

import com.joaovellenich.TruckLogistic.application.gateways.TireGateway;
import com.joaovellenich.TruckLogistic.application.gateways.TruckGateway;
import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.application.useCase.truck.CreateTruckUseCase;
import com.joaovellenich.TruckLogistic.infra.controller.TruckController;
import com.joaovellenich.TruckLogistic.infra.gateways.TruckRepositoryGateway;
import com.joaovellenich.TruckLogistic.infra.persistence.mapper.CompanyMapper;
import com.joaovellenich.TruckLogistic.infra.persistence.mapper.TruckMapper;
import com.joaovellenich.TruckLogistic.infra.persistence.repositories.TruckRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TruckConfig {
    @Bean
    public TruckController truckController(CreateTruckUseCase createTruckUseCase){
        return new TruckController(createTruckUseCase);
    }
    @Bean
    public CreateTruckUseCase createTruckUseCase(TruckGateway truckGateway, UserGateway userGateway, TireGateway tireGateway){
        return new CreateTruckUseCase(truckGateway, userGateway, tireGateway);
    }
    @Bean
    public TruckGateway truckGateway(TruckRepository truckRepository, TruckMapper truckMapper){
        return new TruckRepositoryGateway(truckRepository, truckMapper);
    }
    @Bean
    public TruckMapper truckMapper(CompanyMapper companyMapper){return new TruckMapper(companyMapper);}
}
