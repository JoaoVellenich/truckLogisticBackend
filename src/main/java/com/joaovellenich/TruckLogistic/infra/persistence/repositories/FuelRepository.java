package com.joaovellenich.TruckLogistic.infra.persistence.repositories;

import com.joaovellenich.TruckLogistic.infra.persistence.entities.FuelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuelRepository extends JpaRepository<FuelEntity, UUID> {
}
