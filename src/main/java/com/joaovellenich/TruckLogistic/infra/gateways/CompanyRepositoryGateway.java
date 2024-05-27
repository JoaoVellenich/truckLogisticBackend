package com.joaovellenich.TruckLogistic.infra.gateways;

import com.joaovellenich.TruckLogistic.application.gateways.CompanyGateway;
import com.joaovellenich.TruckLogistic.infra.persistence.entities.CompanyEntity;
import com.joaovellenich.TruckLogistic.infra.persistence.mapper.CompanyMapper;
import com.joaovellenich.TruckLogistic.infra.persistence.repositories.CompanyRepository;
import com.joaovellenich.TruckLogistic.model.Company;
import com.joaovellenich.TruckLogistic.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CompanyRepositoryGateway implements CompanyGateway {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    public CompanyRepositoryGateway(CompanyRepository companyRepository, CompanyMapper companyMapper){
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }
    @Override
    public Company findById(UUID id) {
        CompanyEntity company = this.companyRepository.findById(id).orElse(null);
        if(company != null){
            return this.companyMapper.toDomain(company);
        }
        return null;
    }

    @Override
    public Company saveCompany(Company company) {
        CompanyEntity companyToSave = this.companyMapper.toEntity(company);
        CompanyEntity savedCompany = this.companyRepository.save(companyToSave);
        return this.companyMapper.toDomain(savedCompany);
    }
}
