package com.joaovellenich.TruckLogistic.application.gateways;

import com.joaovellenich.TruckLogistic.model.Truck;

import java.util.List;
import java.util.UUID;

public interface TruckGateway {
    Truck findTruckByPlate(String plate);
    Truck saveTruck(Truck truck);
    Truck getTruckById(UUID truckId) throws Exception;
    List<Truck> getAll(UUID companyId);
}
