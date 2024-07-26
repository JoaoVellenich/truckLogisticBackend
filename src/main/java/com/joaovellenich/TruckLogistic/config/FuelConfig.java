package com.joaovellenich.TruckLogistic.config;

import com.joaovellenich.TruckLogistic.application.gateways.FuelGateway;
import com.joaovellenich.TruckLogistic.application.gateways.TireGateway;
import com.joaovellenich.TruckLogistic.application.gateways.TruckGateway;
import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.application.useCase.fuel.CreateFuelUseCase;
import com.joaovellenich.TruckLogistic.application.useCase.fuel.GetFuelPageUseCase;
import com.joaovellenich.TruckLogistic.infra.controller.FuelController;
import com.joaovellenich.TruckLogistic.infra.gateways.FuelRepositoryGateway;
import com.joaovellenich.TruckLogistic.infra.persistence.mapper.FuelMapper;
import com.joaovellenich.TruckLogistic.infra.persistence.mapper.TruckMapper;
import com.joaovellenich.TruckLogistic.infra.persistence.repositories.FuelRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FuelConfig {
    @Bean
    public FuelController fuelController(CreateFuelUseCase createFuelUseCase, GetFuelPageUseCase getFuelPageUseCase){
        return new FuelController(createFuelUseCase, getFuelPageUseCase);
    }
    @Bean
    public CreateFuelUseCase createFuelUseCase(UserGateway userGateway, TruckGateway truckGateway, FuelGateway fuelGateway, TireGateway tireGateway){
        return new CreateFuelUseCase(userGateway, truckGateway, fuelGateway, tireGateway);
    }
    @Bean
    public GetFuelPageUseCase getFuelPageUseCase(UserGateway userGateway, TruckGateway truckGateway, FuelGateway fuelGateway){
        return new GetFuelPageUseCase(userGateway, fuelGateway, truckGateway);
    }
    @Bean
    public FuelGateway fuelGateway(FuelRepository fuelRepository, FuelMapper fuelMapper){
        return new FuelRepositoryGateway(fuelRepository, fuelMapper);
    }
    @Bean
    public FuelMapper fuelMapper(TruckMapper truckMapper){
        return new FuelMapper(truckMapper);
    }
}
