package com.joaovellenich.TruckLogistic.infra.controller;

import com.joaovellenich.TruckLogistic.application.useCase.fuel.CreateFuelUseCase;
import com.joaovellenich.TruckLogistic.application.useCase.fuel.GetFuelPageUseCase;
import com.joaovellenich.TruckLogistic.dto.fuel.create.CreateFuelRequestDTO;
import com.joaovellenich.TruckLogistic.dto.fuel.create.CreateFuelResponseDTO;
import com.joaovellenich.TruckLogistic.dto.fuel.getFuelPage.GetFuelPageRequestDTO;
import com.joaovellenich.TruckLogistic.model.Fuel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/fuel")
public class FuelController {
    private final CreateFuelUseCase createFuelUseCase;
    private final GetFuelPageUseCase getFuelPageUseCase;

    public FuelController(CreateFuelUseCase createFuelUseCase, GetFuelPageUseCase getFuelPageUseCase) {
        this.createFuelUseCase = createFuelUseCase;
        this.getFuelPageUseCase = getFuelPageUseCase;
    }

    @PostMapping("/")
    private ResponseEntity createFuel(@RequestBody CreateFuelRequestDTO data, HttpServletRequest request){
        UUID userID = (UUID) request.getAttribute("user_id");
        try{
            Fuel fuel = this.createFuelUseCase.execute(data, userID);
            CreateFuelResponseDTO response = CreateFuelResponseDTO.builder()
                    .fuelId(fuel.getId())
                    .date(fuel.getDate())
                    .km(fuel.getKm())
                    .value(fuel.getValue())
                    .trip(fuel.getTrip())
                    .kmL(fuel.getKmL())
                    .price(fuel.getPrice())
                    .liters(fuel.getLiters())
                    .location(fuel.getLocation())
                    .build();

            return ResponseEntity.ok().body(response);
        }catch (Exception error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @PostMapping("/getFuel")
    private ResponseEntity getFuelPage(@RequestBody GetFuelPageRequestDTO data, HttpServletRequest request){
        UUID userID = (UUID) request.getAttribute("user_id");
        try{
            var page = this.getFuelPageUseCase.execute(data, userID);
            return ResponseEntity.ok().body(page);
        }catch (Exception error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

}
