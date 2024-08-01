package com.joaovellenich.TruckLogistic.application.gateways;

import com.joaovellenich.TruckLogistic.model.Tire;

import java.util.List;
import java.util.UUID;

public interface TireGateway {
    Tire saveTire(Tire tire);
    Tire updateTire(Tire tire);
    Tire getById(UUID tireId);
    List<Tire> getTiresFromTruck(UUID truckId);
}
