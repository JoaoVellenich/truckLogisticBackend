package com.joaovellenich.TruckLogistic.infra.persistence.repositories;

import com.joaovellenich.TruckLogistic.infra.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    boolean existsByEmail(String email);
    UserDetails findByEmail(String email);
    UserEntity findOneByEmail(String email);
    List<UserEntity> findByCompanyId(UUID companyId);
}
