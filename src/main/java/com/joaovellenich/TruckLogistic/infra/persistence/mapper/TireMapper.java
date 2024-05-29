package com.joaovellenich.TruckLogistic.infra.persistence.mapper;

import com.joaovellenich.TruckLogistic.infra.persistence.entities.TireEntity;
import com.joaovellenich.TruckLogistic.model.Tire;

public class TireMapper {
    public TireEntity toEntity(Tire tire){
        return TireEntity.builder()
                .id(tire.getId())
                .km(tire.getKm())
                .position(tire.getPosition())
                .belongsTo(tire.getBelongsTo())
                .build();
    }

    public Tire toDomain(TireEntity tire){
        return Tire.builder()
                .id(tire.getId())
                .km(tire.getKm())
                .position(tire.getPosition())
                .belongsTo(tire.getBelongsTo())
                .build();
    }
}
