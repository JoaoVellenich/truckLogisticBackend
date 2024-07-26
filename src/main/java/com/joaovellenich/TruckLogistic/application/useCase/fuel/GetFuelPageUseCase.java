package com.joaovellenich.TruckLogistic.application.useCase.fuel;

import com.joaovellenich.TruckLogistic.application.gateways.FuelGateway;
import com.joaovellenich.TruckLogistic.application.gateways.TruckGateway;
import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.dto.fuel.getFuelPage.GetFuelPageRequestDTO;
import com.joaovellenich.TruckLogistic.model.Company;
import com.joaovellenich.TruckLogistic.model.Fuel;
import com.joaovellenich.TruckLogistic.model.Truck;
import com.joaovellenich.TruckLogistic.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class GetFuelPageUseCase {

    private final UserGateway userGateway;
    private final FuelGateway fuelGateway;
    private final TruckGateway truckGateway;

    public GetFuelPageUseCase(UserGateway userGateway, FuelGateway fuelGateway, TruckGateway truckGateway) {
        this.userGateway = userGateway;
        this.fuelGateway = fuelGateway;
        this.truckGateway = truckGateway;
    }

    public Page<Fuel> execute(GetFuelPageRequestDTO request, UUID userId) throws Exception{
        User userData = this.userGateway.getUserById(userId);
        Company truckCompany = userData.getCompany();

        Truck truckFound = this.truckGateway.getTruckById(request.truckId());
        if(truckFound.getCompany().getId().equals(truckCompany.getId())){
            Pageable pageable = PageRequest.of(request.page(), request.size());
            var page = this.fuelGateway.getFuelPage(request.truckId(), pageable);
            return page;
        }else{
            throw new Exception("User not allowed to use this truck");
        }
    }
}
