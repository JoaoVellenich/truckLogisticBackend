package com.joaovellenich.TruckLogistic.application.useCase.truck;

import com.joaovellenich.TruckLogistic.application.gateways.TireGateway;
import com.joaovellenich.TruckLogistic.application.gateways.TruckGateway;
import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.model.Truck;

import java.util.List;

public class GetTrucksInfoUseCase {

    private final TruckGateway truckGateway;
    public GetTrucksInfoUseCase(TruckGateway truckGateway){
        this.truckGateway = truckGateway;
    }
    public List<Truck> execute(){
        List<Truck> trucks = this.truckGateway.getAll();
        return trucks;
    }
}
