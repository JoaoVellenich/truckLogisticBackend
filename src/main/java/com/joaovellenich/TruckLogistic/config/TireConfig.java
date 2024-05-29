package com.joaovellenich.TruckLogistic.config;

import com.joaovellenich.TruckLogistic.application.gateways.TireGateway;
import com.joaovellenich.TruckLogistic.infra.gateways.TireRepositoryGateway;
import com.joaovellenich.TruckLogistic.infra.persistence.mapper.TireMapper;
import com.joaovellenich.TruckLogistic.infra.persistence.repositories.TireRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TireConfig {
    @Bean
    public TireGateway tireGateway(TireRepository tireRepository, TireMapper tireMapper){
        return new TireRepositoryGateway(tireRepository, tireMapper);
    }
    @Bean
    public TireMapper tireMapper(){return new TireMapper();}
}
