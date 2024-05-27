package com.joaovellenich.TruckLogistic.infra.controller;

import com.joaovellenich.TruckLogistic.application.useCase.company.CreateCompanyUseCase;
import com.joaovellenich.TruckLogistic.dto.company.create.CreateCompanyRequestDTO;
import com.joaovellenich.TruckLogistic.model.Company;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    private final CreateCompanyUseCase createCompanyUseCase;
    public CompanyController(CreateCompanyUseCase createCompanyUseCase){
        this.createCompanyUseCase = createCompanyUseCase;
    }
    @PostMapping("/create")
    public ResponseEntity createCompany(@RequestBody CreateCompanyRequestDTO data){
        Company company = this.createCompanyUseCase.execute(data.name());
        return ResponseEntity.ok().body(company);
    }
}
