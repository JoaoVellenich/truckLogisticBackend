package com.joaovellenich.TruckLogistic.infra.persistence.repositories;

import com.joaovellenich.TruckLogistic.infra.persistence.entities.TireEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TireRepository extends JpaRepository<TireEntity, UUID> {
    List<TireEntity> findAllByIsActiveTrueAndBelongsToOrderByPosition(UUID belongsTo);
    Optional<TireEntity> findById(UUID id);
}

