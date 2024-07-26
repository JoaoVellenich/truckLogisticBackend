package com.joaovellenich.TruckLogistic.dto.fuel.getFuelPage;

import java.util.UUID;

public record GetFuelPageRequestDTO (
        UUID truckId,
        int page,
        int size
){
}
