package com.joaovellenich.TruckLogistic.application.gateways;

import com.joaovellenich.TruckLogistic.model.Fuel;

public interface FuelGateway {
    Fuel createFuel(Fuel fuel);
}
