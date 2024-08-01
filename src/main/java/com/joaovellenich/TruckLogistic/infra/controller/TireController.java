package com.joaovellenich.TruckLogistic.infra.controller;

import com.joaovellenich.TruckLogistic.application.useCase.tire.ChangeTireUseCase;
import com.joaovellenich.TruckLogistic.dto.tire.create.ChangeTireRequestDTO;
import com.joaovellenich.TruckLogistic.model.Tire;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tire")
public class TireController {
    private final ChangeTireUseCase changeTireUseCase;

    public TireController(ChangeTireUseCase changeTireUseCase) {
        this.changeTireUseCase = changeTireUseCase;
    }

    @PostMapping("/")
    public ResponseEntity changeTire(@RequestBody ChangeTireRequestDTO dto,  HttpServletRequest request){
        UUID userID = (UUID) request.getAttribute("user_id");
        try{
            Tire newTire = changeTireUseCase.execute(dto, userID);
            return ResponseEntity.ok().body(newTire);
        }catch (Exception err){
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }
}
