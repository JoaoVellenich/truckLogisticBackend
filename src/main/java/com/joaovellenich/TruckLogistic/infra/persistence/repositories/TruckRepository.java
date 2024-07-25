package com.joaovellenich.TruckLogistic.infra.persistence.repositories;

import com.joaovellenich.TruckLogistic.infra.persistence.entities.TruckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TruckRepository extends JpaRepository<TruckEntity, UUID> {
    TruckEntity findByPlate(String plate);
    List<TruckEntity> findAllByCompanyId(UUID companyId);
}
