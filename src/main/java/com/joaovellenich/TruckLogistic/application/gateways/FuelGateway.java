package com.joaovellenich.TruckLogistic.application.gateways;

import com.joaovellenich.TruckLogistic.model.Fuel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface FuelGateway {
    Fuel createFuel(Fuel fuel);
    Page<Fuel> getFuelPage(UUID truckId, Pageable pageable);
}
