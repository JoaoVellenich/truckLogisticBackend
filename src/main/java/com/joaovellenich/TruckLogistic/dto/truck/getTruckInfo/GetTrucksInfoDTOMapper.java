package com.joaovellenich.TruckLogistic.dto.truck.getTruckInfo;

import com.joaovellenich.TruckLogistic.model.Truck;

import java.util.List;
import java.util.stream.Collectors;

public class GetTrucksInfoDTOMapper {
    public List<GetTrucksInfoResponseDTO> toResponse(List<Truck> trucks){
        return trucks.stream().map((truck -> {
            return GetTrucksInfoResponseDTO.builder().id(truck.getId()).plate(truck.getPlate()).description(truck.getDescription()).km(truck.getKm()).build();
        })).collect(Collectors.toList());
    }
}
