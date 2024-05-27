package com.joaovellenich.TruckLogistic.infra.persistence.mapper;

import com.joaovellenich.TruckLogistic.infra.persistence.entities.CompanyEntity;
import com.joaovellenich.TruckLogistic.model.Company;

import java.util.Collections;
import java.util.stream.Collectors;

public class CompanyMapper {

    public Company toDomain(CompanyEntity company){
        return Company.builder()
                .id(company.getId())
                .name(company.getName())
                .build();
    }

    public CompanyEntity toEntity(Company company){
        return CompanyEntity.builder()
                .id(company.getId())
                .name(company.getName())
                .build();
    }
}
