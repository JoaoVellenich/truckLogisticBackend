package com.joaovellenich.TruckLogistic.infra.gateways;

import com.joaovellenich.TruckLogistic.application.gateways.TireGateway;
import com.joaovellenich.TruckLogistic.infra.persistence.entities.TireEntity;
import com.joaovellenich.TruckLogistic.infra.persistence.mapper.TireMapper;
import com.joaovellenich.TruckLogistic.infra.persistence.repositories.TireRepository;
import com.joaovellenich.TruckLogistic.model.Tire;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class TireRepositoryGateway implements TireGateway {
    private final TireRepository tireRepository;
    private final TireMapper tireMapper;
    public TireRepositoryGateway(TireRepository tireRepository, TireMapper tireMapper){
        this.tireRepository = tireRepository;
        this.tireMapper = tireMapper;
    }
    @Override
    public Tire saveTire(Tire tire) {
        TireEntity tireToSave = this.tireMapper.toEntity(tire);
        return this.tireMapper.toDomain(this.tireRepository.save(tireToSave));
    }

    @Override
    public Tire updateTire(Tire tire) {
        TireEntity tireToSave = this.tireMapper.toEntity(tire);
        return this.tireMapper.toDomain(this.tireRepository.save(tireToSave));
    }

    @Override
    public Tire getById(UUID tireId) {
        Optional<TireEntity> entity = this.tireRepository.findById(tireId);
        return entity.map(this.tireMapper::toDomain).orElse(null);
    }

    @Override
    public List<Tire> getTiresFromTruck(UUID truckId) {
        List<TireEntity> tires = this.tireRepository.findAllByIsActiveTrueAndBelongsToOrderByPosition(truckId);
        return tires.stream().map(this.tireMapper::toDomain).collect(Collectors.toList());
    }
}
