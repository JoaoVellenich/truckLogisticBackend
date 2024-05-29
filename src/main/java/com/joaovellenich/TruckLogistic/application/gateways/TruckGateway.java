package com.joaovellenich.TruckLogistic.application.gateways;

import com.joaovellenich.TruckLogistic.model.Truck;

public interface TruckGateway {
    Truck findTruckByPlate(String plate);
    Truck saveTruck(Truck truck);
}
