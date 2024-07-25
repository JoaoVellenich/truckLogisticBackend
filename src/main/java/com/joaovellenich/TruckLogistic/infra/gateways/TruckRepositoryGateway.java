package com.joaovellenich.TruckLogistic.infra.gateways;

import com.joaovellenich.TruckLogistic.application.gateways.TruckGateway;
import com.joaovellenich.TruckLogistic.infra.persistence.entities.TruckEntity;
import com.joaovellenich.TruckLogistic.infra.persistence.mapper.TruckMapper;
import com.joaovellenich.TruckLogistic.infra.persistence.repositories.TruckRepository;
import com.joaovellenich.TruckLogistic.model.Truck;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class TruckRepositoryGateway implements TruckGateway {
    private final TruckRepository truckRepository;
    private final TruckMapper truckMapper;
    public TruckRepositoryGateway(TruckRepository truckRepository, TruckMapper truckMapper){
        this.truckRepository = truckRepository;
        this.truckMapper = truckMapper;
    }
    @Override
    public Truck findTruckByPlate(String plate) {
        TruckEntity foundTruck = this.truckRepository.findByPlate(plate);
        if(foundTruck != null){
            return this.truckMapper.toDomain(foundTruck);
        }
        return null;
    }

    @Override
    public Truck saveTruck(Truck truck) {
        TruckEntity entityToSave = this.truckMapper.toEntity(truck);
        return this.truckMapper.toDomain(this.truckRepository.save(entityToSave));
    }

    @Override
    public Truck getTruckById(UUID truckId) throws Exception {
        Optional<TruckEntity> entity = this.truckRepository.findById(truckId);
        if(entity.isEmpty()){
            throw new Exception("Truck not found");
        }
        return this.truckMapper.toDomain(entity.get());
    }

    @Override
    public List<Truck> getAll(UUID companyId) {
        List<TruckEntity> entities = this.truckRepository.findAllByCompanyId(companyId);
        return entities.stream().map(this.truckMapper::toDomain).collect(Collectors.toList());
    }

}
