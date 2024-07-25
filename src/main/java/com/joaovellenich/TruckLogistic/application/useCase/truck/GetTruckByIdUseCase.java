package com.joaovellenich.TruckLogistic.application.useCase.truck;

import com.joaovellenich.TruckLogistic.application.gateways.TireGateway;
import com.joaovellenich.TruckLogistic.application.gateways.TruckGateway;
import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.model.Company;
import com.joaovellenich.TruckLogistic.model.Tire;
import com.joaovellenich.TruckLogistic.model.Truck;
import com.joaovellenich.TruckLogistic.model.User;

import java.util.List;
import java.util.UUID;

public class GetTruckByIdUseCase {
    private final UserGateway userGateway;
    private final TruckGateway truckGateway;
    private final TireGateway tireGateway;
    public GetTruckByIdUseCase(TruckGateway truckGateway, TireGateway tireGateway, UserGateway userGateway){
        this.truckGateway = truckGateway;
        this.userGateway = userGateway;
        this.tireGateway = tireGateway;
    }
    public Truck execute(UUID truckId, UUID userId) throws Exception{
        try{
            User userData = this.userGateway.getUserById(userId);
            Company truckCompany = userData.getCompany();

            Truck truck = this.truckGateway.getTruckById(truckId);

            if(!truck.getCompany().getId().equals(truckCompany.getId())){
                throw new Exception("User not allowed to view this truck");
            }

            List<Tire> tires = this.tireGateway.getTiresFromTruck(truckId);
            System.out.println(tires);
            truck.setTires(tires);
            return truck;
        }catch (Exception error){
            System.out.println(error);
            throw new Exception("Truck not found");
        }
    }
}
