package com.joaovellenich.TruckLogistic.infra.gateways;

import com.joaovellenich.TruckLogistic.application.gateways.TireGateway;
import com.joaovellenich.TruckLogistic.infra.persistence.entities.TireEntity;
import com.joaovellenich.TruckLogistic.infra.persistence.mapper.TireMapper;
import com.joaovellenich.TruckLogistic.infra.persistence.repositories.TireRepository;
import com.joaovellenich.TruckLogistic.model.Tire;

public class TireRepositoryGateway implements TireGateway {
    private final TireRepository tireRepositoryl;
    private final TireMapper tireMapper;
    public TireRepositoryGateway(TireRepository tireRepository, TireMapper tireMapper){
        this.tireRepositoryl = tireRepository;
        this.tireMapper = tireMapper;
    }
    @Override
    public Tire saveTire(Tire tire) {
        TireEntity tireToSave = this.tireMapper.toEntity(tire);
        return this.tireMapper.toDomain(this.tireRepositoryl.save(tireToSave));
    }
}
