package com.joaovellenich.TruckLogistic.config;

import com.joaovellenich.TruckLogistic.application.gateways.TireGateway;
import com.joaovellenich.TruckLogistic.application.gateways.TruckGateway;
import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.application.useCase.truck.CreateTruckUseCase;
import com.joaovellenich.TruckLogistic.application.useCase.truck.GetTruckByIdUseCase;
import com.joaovellenich.TruckLogistic.application.useCase.truck.GetTrucksInfoUseCase;
import com.joaovellenich.TruckLogistic.dto.truck.getTruckInfo.GetTrucksInfoDTOMapper;
import com.joaovellenich.TruckLogistic.infra.controller.TruckController;
import com.joaovellenich.TruckLogistic.infra.gateways.TruckRepositoryGateway;
import com.joaovellenich.TruckLogistic.infra.persistence.mapper.CompanyMapper;
import com.joaovellenich.TruckLogistic.infra.persistence.mapper.TireMapper;
import com.joaovellenich.TruckLogistic.infra.persistence.mapper.TruckMapper;
import com.joaovellenich.TruckLogistic.infra.persistence.repositories.TruckRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TruckConfig {
    @Bean
    public TruckController truckController(CreateTruckUseCase createTruckUseCase, GetTrucksInfoUseCase getTrucksInfoUseCase, GetTrucksInfoDTOMapper getTrucksInfoDTOMapper, GetTruckByIdUseCase getTruckByIdUseCase){
        return new TruckController(createTruckUseCase, getTrucksInfoUseCase, getTrucksInfoDTOMapper, getTruckByIdUseCase);
    }
    @Bean
    public CreateTruckUseCase createTruckUseCase(TruckGateway truckGateway, UserGateway userGateway, TireGateway tireGateway){
        return new CreateTruckUseCase(truckGateway, userGateway, tireGateway);
    }
    @Bean
    public GetTrucksInfoUseCase getTruckUseCase(TruckGateway truckGateway, UserGateway userGateway){
        return new GetTrucksInfoUseCase(truckGateway, userGateway);
    }
    @Bean
    public GetTruckByIdUseCase getTruckByIdUseCase(TruckGateway truckGateway, TireGateway tireGateway){
        return new GetTruckByIdUseCase(truckGateway, tireGateway);
    }
    @Bean
    public TruckGateway truckGateway(TruckRepository truckRepository, TruckMapper truckMapper){
        return new TruckRepositoryGateway(truckRepository, truckMapper);
    }
    @Bean
    public TruckMapper truckMapper(CompanyMapper companyMapper, TireMapper tireMapper){return new TruckMapper(companyMapper, tireMapper);}
    @Bean
    public GetTrucksInfoDTOMapper getTrucksInfoDTOMapper(){return new GetTrucksInfoDTOMapper();}
}
