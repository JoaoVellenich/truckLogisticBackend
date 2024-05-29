package com.joaovellenich.TruckLogistic.infra.controller;

import com.joaovellenich.TruckLogistic.application.useCase.truck.CreateTruckUseCase;
import com.joaovellenich.TruckLogistic.dto.truck.create.CreateTruckRequestDTO;
import com.joaovellenich.TruckLogistic.model.Truck;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/trucks")
public class TruckController {
    private final CreateTruckUseCase createTruckUseCase;

    public TruckController(CreateTruckUseCase createTruckUseCase){
        this.createTruckUseCase = createTruckUseCase;
    }
    @GetMapping("/")
    public ResponseEntity getTrucks(){
        return ResponseEntity.ok().body("OK");
    }
    @PostMapping("/create")
    public ResponseEntity createTruck(@RequestBody CreateTruckRequestDTO data, HttpServletRequest request){
        UUID userID = (UUID) request.getAttribute("user_id");
        try{
            Truck savedTruck = this.createTruckUseCase.execute(data, userID);
            return ResponseEntity.ok().body(savedTruck);
        }catch (Exception error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }}
}
