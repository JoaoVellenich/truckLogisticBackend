package com.joaovellenich.TruckLogistic.application.useCase.fuel;

import com.joaovellenich.TruckLogistic.application.gateways.FuelGateway;
import com.joaovellenich.TruckLogistic.application.gateways.TireGateway;
import com.joaovellenich.TruckLogistic.application.gateways.TruckGateway;
import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.dto.fuel.create.CreateFuelRequestDTO;
import com.joaovellenich.TruckLogistic.model.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CreateFuelUseCase {
    private final UserGateway userGateway;
    private final TruckGateway truckGateway;
    private final FuelGateway fuelGateway;
    private final TireGateway tireGateway;


    public CreateFuelUseCase(UserGateway userGateway, TruckGateway truckGateway, FuelGateway fuelGateway, TireGateway tireGateway) {
        this.userGateway = userGateway;
        this.truckGateway = truckGateway;
        this.fuelGateway = fuelGateway;
        this.tireGateway = tireGateway;
    }

    public Fuel execute(CreateFuelRequestDTO request, UUID userId)throws Exception{
        User userData = this.userGateway.getUserById(userId);
        Company truckCompany = userData.getCompany();

        Truck truckFound = this.truckGateway.getTruckById(request.truckId());
        if(truckFound.getCompany().getId().equals(truckCompany.getId())){

            if(request.km() < truckFound.getKm()){
                throw new Exception("Error on km");
            }

            Double liters = request.value() / request.price();
            Double trip = request.km() - truckFound.getKm();
            Double kmL = trip / liters;

            truckFound.setKm(request.km());
            Truck savedTruck = this.truckGateway.updateFuel(truckFound);

            List<Tire> tires = this.tireGateway.getTiresFromTruck(savedTruck.getId());
            List<Tire> updatedTires = tires.stream().map((tire -> {
                tire.setKm(tire.getKm() + trip);
                return this.tireGateway.saveTire(tire);
            })).toList();
            savedTruck.setTires(updatedTires);

            Fuel fuelToSave = Fuel.builder()
                    .date(request.date())
                    .truck(savedTruck)
                    .value(request.value())
                    .km(request.km())
                    .trip(trip)
                    .kmL(kmL)
                    .price(request.price())
                    .liters(liters)
                    .location(request.location())
                    .build();
            return this.fuelGateway.createFuel(fuelToSave);
        }else{
            throw new Exception("User not allowed to use this truck");
        }
    }
}
