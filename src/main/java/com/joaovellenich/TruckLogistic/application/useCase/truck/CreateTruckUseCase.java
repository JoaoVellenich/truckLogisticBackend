package com.joaovellenich.TruckLogistic.application.useCase.truck;

import com.joaovellenich.TruckLogistic.application.gateways.TireGateway;
import com.joaovellenich.TruckLogistic.application.gateways.TruckGateway;
import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.dto.truck.create.CreateTruckRequestDTO;
import com.joaovellenich.TruckLogistic.model.Company;
import com.joaovellenich.TruckLogistic.model.Tire;
import com.joaovellenich.TruckLogistic.model.Truck;
import com.joaovellenich.TruckLogistic.model.User;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreateTruckUseCase {
    private final TruckGateway truckGateway;
    private final UserGateway userGateway;
    private final TireGateway tireGateway;

    public CreateTruckUseCase(TruckGateway truckGateway, UserGateway userGateway, TireGateway tireGateway){
        this.truckGateway = truckGateway;
        this.userGateway = userGateway;
        this.tireGateway = tireGateway;
    }
    public Truck execute(CreateTruckRequestDTO data, UUID userID) throws Exception{
        // Verify if already exists truck with this plate
        Truck truckFound = this.truckGateway.findTruckByPlate(data.plate());

        User userData = this.userGateway.getUserById(userID);
        Company truckCompany = userData.getCompany();

        if(truckFound == null || truckFound.getCompany().getId() != truckCompany.getId()){
            Truck truckToSave = Truck.builder()
                    .company(truckCompany)
                    .plate(data.plate())
                    .description(data.description())
                    .km(data.km())
                    .numberOfAxle(data.numberOfAxle())
                    .build();
            Truck savedTruck = this.truckGateway.saveTruck(truckToSave);
            if(data.hasNewTires()){
                int numberOfTires = data.numberOfAxle() * 4 - 2;
                List<Tire> tires = IntStream.range(0, numberOfTires).mapToObj(i -> {
                    Tire tire = Tire.builder()
                            .km(0)
                            .position(i+1)
                            .belongsTo(savedTruck.getId())
                            .build();
                    return this.tireGateway.saveTire(tire);
                }).toList();
                savedTruck.setTires(tires);
            }
            return savedTruck;
        }else{
            throw new Exception("Truck already saved with this plate");
        }
    }
}
