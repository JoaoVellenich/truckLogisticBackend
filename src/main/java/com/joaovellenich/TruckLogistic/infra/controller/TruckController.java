package com.joaovellenich.TruckLogistic.infra.controller;

import com.joaovellenich.TruckLogistic.application.useCase.truck.CreateTruckUseCase;
import com.joaovellenich.TruckLogistic.application.useCase.truck.GetTrucksInfoUseCase;
import com.joaovellenich.TruckLogistic.dto.truck.create.CreateTruckRequestDTO;
import com.joaovellenich.TruckLogistic.dto.truck.getTruckInfo.GetTrucksInfoDTOMapper;
import com.joaovellenich.TruckLogistic.model.Truck;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/trucks")
public class TruckController {
    private final CreateTruckUseCase createTruckUseCase;
    private final GetTrucksInfoUseCase getTruckUseCase;
    private final GetTrucksInfoDTOMapper getTrucksInfoDTOMapper;

    public TruckController(CreateTruckUseCase createTruckUseCase, GetTrucksInfoUseCase getTruckUseCase, GetTrucksInfoDTOMapper getTrucksInfoDTOMapper){
        this.createTruckUseCase = createTruckUseCase;
        this.getTruckUseCase = getTruckUseCase;
        this.getTrucksInfoDTOMapper = getTrucksInfoDTOMapper;
    }
    @GetMapping("/")
    public ResponseEntity getTrucks(){
        List<Truck> trucks = this.getTruckUseCase.execute();
        return ResponseEntity.ok().body(this.getTrucksInfoDTOMapper.toResponse(trucks));
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
