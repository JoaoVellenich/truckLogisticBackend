package com.joaovellenich.TruckLogistic.infra.persistence.mapper;

import com.joaovellenich.TruckLogistic.infra.persistence.entities.TireEntity;
import com.joaovellenich.TruckLogistic.infra.persistence.entities.TruckEntity;
import com.joaovellenich.TruckLogistic.model.Truck;

import java.util.stream.Collectors;

public class TruckMapper {
    private final CompanyMapper companyMapper;
    private  final TireMapper tireMapper;
    public TruckMapper(CompanyMapper companyMapper, TireMapper tireMapper){
        this.companyMapper = companyMapper;
        this.tireMapper = tireMapper;
    }
    public TruckEntity toEntity(Truck truck){
        return TruckEntity.builder()
                .id(truck.getId())
                .company(this.companyMapper.toEntity(truck.getCompany()))
                .plate(truck.getPlate())
                .description(truck.getDescription())
                .km(truck.getKm())
                .numberOfAxle(truck.getNumberOfAxle())
                .build();
    }
    public Truck toDomain(TruckEntity truck){
        return Truck.builder()
                .id(truck.getId())
                .company(this.companyMapper.toDomain(truck.getCompany()))
                .plate(truck.getPlate())
                .description(truck.getDescription())
                .km(truck.getKm())
                .numberOfAxle(truck.getNumberOfAxle())
                .build();
    }
}
