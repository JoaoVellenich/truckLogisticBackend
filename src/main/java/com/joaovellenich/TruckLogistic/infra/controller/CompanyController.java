package com.joaovellenich.TruckLogistic.infra.controller;

import com.joaovellenich.TruckLogistic.application.useCase.company.CreateCompanyUseCase;
import com.joaovellenich.TruckLogistic.application.useCase.company.ListUsersUseCase;
import com.joaovellenich.TruckLogistic.dto.company.create.CreateCompanyRequestDTO;
import com.joaovellenich.TruckLogistic.dto.company.listUsers.ListUserDTOMapper;
import com.joaovellenich.TruckLogistic.model.Company;
import com.joaovellenich.TruckLogistic.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    private final CreateCompanyUseCase createCompanyUseCase;
    private final ListUsersUseCase listUsersUseCase;
    private final ListUserDTOMapper listUserDTOMapper;
    public CompanyController(CreateCompanyUseCase createCompanyUseCase, ListUsersUseCase listUsersUseCase, ListUserDTOMapper listUserDTOMapper){
        this.createCompanyUseCase = createCompanyUseCase;
        this.listUsersUseCase = listUsersUseCase;
        this.listUserDTOMapper = listUserDTOMapper;
    }
    @PostMapping("/create")
    public ResponseEntity createCompany(@RequestBody CreateCompanyRequestDTO data){
        Company company = this.createCompanyUseCase.execute(data.name());
        return ResponseEntity.ok().body(company);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity listUsersFromCompany(@PathVariable UUID id, HttpServletRequest request){
        UUID userID = (UUID) request.getAttribute("user_id");
        try{
            List<User> users = this.listUsersUseCase.execute(id, userID);
            return ResponseEntity.ok().body(this.listUserDTOMapper.toResponse(users));
        }catch (Exception error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
}
