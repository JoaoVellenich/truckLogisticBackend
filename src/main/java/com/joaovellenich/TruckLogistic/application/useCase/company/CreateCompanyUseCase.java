package com.joaovellenich.TruckLogistic.application.useCase.company;

import com.joaovellenich.TruckLogistic.application.gateways.CompanyGateway;
import com.joaovellenich.TruckLogistic.model.Company;

public class CreateCompanyUseCase {
    private final CompanyGateway companyGateway;
    public CreateCompanyUseCase(CompanyGateway companyGateway){
        this.companyGateway = companyGateway;
    }
    public Company execute(String name){
        return this.companyGateway.saveCompany(Company.builder().name(name).build());
    }
}
