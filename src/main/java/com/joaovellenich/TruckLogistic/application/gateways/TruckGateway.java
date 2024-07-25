package com.joaovellenich.TruckLogistic.application.gateways;

import com.joaovellenich.TruckLogistic.model.Truck;

import java.util.List;

public interface TruckGateway {
    Truck findTruckByPlate(String plate);
    Truck saveTruck(Truck truck);
    List<Truck> getAll();
}
