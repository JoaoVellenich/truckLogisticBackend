package com.joaovellenich.TruckLogistic.infra.persistence.mapper;

import com.joaovellenich.TruckLogistic.infra.persistence.entities.FuelEntity;
import com.joaovellenich.TruckLogistic.model.Fuel;

public class FuelMapper {
    private final TruckMapper truckMapper;
    private final CompanyMapper companyMapper;

    public FuelMapper(TruckMapper truckMapper, CompanyMapper companyMapper) {
        this.truckMapper = truckMapper;
        this.companyMapper = companyMapper;
    }

    public Fuel toDomain(FuelEntity fuel){
        return Fuel.builder()
                .id(fuel.getId())
                .date(fuel.getDate())
                .truck(this.truckMapper.toDomain(fuel.getTruck()))
                .value(fuel.getValue())
                .km(fuel.getKm())
                .trip(fuel.getTrip())
                .kmL(fuel.getKmL())
                .price(fuel.getPrice())
                .liters(fuel.getLiters())
                .location(fuel.getLocation())
                .company(this.companyMapper.toDomain(fuel.getCompany()))
                .build();
    }

    public FuelEntity toEntity(Fuel fuel){
        return FuelEntity.builder()
                .id(fuel.getId())
                .date(fuel.getDate())
                .truck(this.truckMapper.toEntity(fuel.getTruck()))
                .value(fuel.getValue())
                .km(fuel.getKm())
                .trip(fuel.getTrip())
                .kmL(fuel.getKmL())
                .price(fuel.getPrice())
                .liters(fuel.getLiters())
                .location(fuel.getLocation())
                .company(this.companyMapper.toEntity(fuel.getCompany()))
                .build();
    }
}
