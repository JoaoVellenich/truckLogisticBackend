package com.joaovellenich.TruckLogistic.application.gateways;

import com.joaovellenich.TruckLogistic.model.Truck;

import java.util.List;
import java.util.UUID;

public interface TruckGateway {
    Truck findTruckByPlateAndCompanyId(String plate, UUID companyId);
    Truck saveTruck(Truck truck);
    Truck getTruckById(UUID truckId) throws Exception;
    List<Truck> getAll(UUID companyId);
    Truck updateFuel(Truck truck);
}
