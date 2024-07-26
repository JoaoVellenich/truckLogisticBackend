package com.joaovellenich.TruckLogistic.infra.controller;

import com.joaovellenich.TruckLogistic.application.useCase.fuel.CreateFuelUseCase;
import com.joaovellenich.TruckLogistic.dto.fuel.create.CreateFuelRequestDTO;
import com.joaovellenich.TruckLogistic.model.Fuel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/fuel")
public class FuelController {
    private final CreateFuelUseCase createFuelUseCase;

    public FuelController(CreateFuelUseCase createFuelUseCase) {
        this.createFuelUseCase = createFuelUseCase;
    }

    @PostMapping("/")
    private ResponseEntity createFuel(@RequestBody CreateFuelRequestDTO data, HttpServletRequest request){
        UUID userID = (UUID) request.getAttribute("user_id");
        try{
            Fuel fuel = this.createFuelUseCase.execute(data, userID);
            return ResponseEntity.ok().body(fuel);
        }catch (Exception error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

}
