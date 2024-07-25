package com.joaovellenich.TruckLogistic.application.useCase.truck;

import com.joaovellenich.TruckLogistic.application.gateways.TireGateway;
import com.joaovellenich.TruckLogistic.application.gateways.TruckGateway;
import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.model.Company;
import com.joaovellenich.TruckLogistic.model.Truck;
import com.joaovellenich.TruckLogistic.model.User;

import java.util.List;
import java.util.UUID;

public class GetTrucksInfoUseCase {
    private final UserGateway userGateway;
    private final TruckGateway truckGateway;
    public GetTrucksInfoUseCase(TruckGateway truckGateway, UserGateway userGateway){
        this.truckGateway = truckGateway;
        this.userGateway = userGateway;
    }
    public List<Truck> execute(UUID userID) throws Exception {
        User userData = this.userGateway.getUserById(userID);
        Company truckCompany = userData.getCompany();
        List<Truck> trucks = this.truckGateway.getAll(truckCompany.getId());
        return trucks;
    }
}
