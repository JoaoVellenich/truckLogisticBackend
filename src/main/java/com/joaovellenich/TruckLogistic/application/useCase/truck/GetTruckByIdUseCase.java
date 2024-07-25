package com.joaovellenich.TruckLogistic.application.useCase.truck;

import com.joaovellenich.TruckLogistic.application.gateways.TireGateway;
import com.joaovellenich.TruckLogistic.application.gateways.TruckGateway;
import com.joaovellenich.TruckLogistic.model.Tire;
import com.joaovellenich.TruckLogistic.model.Truck;

import java.util.List;
import java.util.UUID;

public class GetTruckByIdUseCase {
    private final TruckGateway truckGateway;
    private final TireGateway tireGateway;
    public GetTruckByIdUseCase(TruckGateway truckGateway, TireGateway tireGateway){
        this.truckGateway = truckGateway;
        this.tireGateway = tireGateway;
    }
    public Truck execute(UUID truckId) throws Exception{
        try{
            Truck truck = this.truckGateway.getTruckById(truckId);
            List<Tire> tires = this.tireGateway.getTiresFromTruck(truckId);
            System.out.println(tires);
            truck.setTires(tires);
            return truck;
        }catch (Exception error){
            System.out.println(error);
            throw new Exception("Truck not found");
        }
    }
}
