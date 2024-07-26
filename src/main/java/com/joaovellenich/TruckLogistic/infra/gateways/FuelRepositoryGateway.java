package com.joaovellenich.TruckLogistic.infra.gateways;

import com.joaovellenich.TruckLogistic.application.gateways.FuelGateway;
import com.joaovellenich.TruckLogistic.infra.persistence.entities.FuelEntity;
import com.joaovellenich.TruckLogistic.infra.persistence.mapper.FuelMapper;
import com.joaovellenich.TruckLogistic.infra.persistence.repositories.FuelRepository;
import com.joaovellenich.TruckLogistic.model.Fuel;

public class FuelRepositoryGateway implements FuelGateway {
    private final FuelRepository fuelRepository;
    private final FuelMapper fuelMapper;

    public FuelRepositoryGateway(FuelRepository fuelRepository, FuelMapper fuelMapper) {
        this.fuelRepository = fuelRepository;
        this.fuelMapper = fuelMapper;
    }

    @Override
    public Fuel createFuel(Fuel fuel) {
        FuelEntity entity = this.fuelMapper.toEntity(fuel);
        return this.fuelMapper.toDomain(this.fuelRepository.save(entity));
    }
}
