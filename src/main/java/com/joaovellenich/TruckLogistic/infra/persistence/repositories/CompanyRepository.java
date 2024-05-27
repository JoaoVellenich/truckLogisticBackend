package com.joaovellenich.TruckLogistic.infra.persistence.repositories;

import com.joaovellenich.TruckLogistic.infra.persistence.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
}
