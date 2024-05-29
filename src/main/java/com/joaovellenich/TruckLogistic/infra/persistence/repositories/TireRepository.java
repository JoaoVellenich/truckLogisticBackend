package com.joaovellenich.TruckLogistic.infra.persistence.repositories;

import com.joaovellenich.TruckLogistic.infra.persistence.entities.TireEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TireRepository extends JpaRepository<TireEntity, UUID> {
}
