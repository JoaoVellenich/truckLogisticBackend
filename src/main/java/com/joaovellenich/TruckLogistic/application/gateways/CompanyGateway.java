package com.joaovellenich.TruckLogistic.application.gateways;

import com.joaovellenich.TruckLogistic.model.Company;
import com.joaovellenich.TruckLogistic.model.User;

import java.util.UUID;

public interface CompanyGateway {
    Company findById(UUID id);
    Company saveCompany(Company company);
}
