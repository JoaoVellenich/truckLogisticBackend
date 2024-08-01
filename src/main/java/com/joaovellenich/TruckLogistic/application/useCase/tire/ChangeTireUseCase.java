package com.joaovellenich.TruckLogistic.application.useCase.tire;

import com.joaovellenich.TruckLogistic.application.gateways.TireGateway;
import com.joaovellenich.TruckLogistic.application.gateways.TruckGateway;
import com.joaovellenich.TruckLogistic.application.gateways.UserGateway;
import com.joaovellenich.TruckLogistic.dto.tire.create.ChangeTireRequestDTO;
import com.joaovellenich.TruckLogistic.model.Company;
import com.joaovellenich.TruckLogistic.model.Tire;
import com.joaovellenich.TruckLogistic.model.Truck;
import com.joaovellenich.TruckLogistic.model.User;

import java.util.UUID;

public class ChangeTireUseCase {
    private final UserGateway userGateway;
    private final TireGateway tireGateway;
    private final TruckGateway truckGateway;

    public ChangeTireUseCase(UserGateway userGateway, TireGateway tireGateway, TruckGateway truckGateway) {
        this.userGateway = userGateway;
        this.tireGateway = tireGateway;
        this.truckGateway = truckGateway;
    }
    public Tire execute(ChangeTireRequestDTO data, UUID userId) throws Exception{
        User userData = this.userGateway.getUserById(userId);
        Company truckCompany = userData.getCompany();

        Tire tire = this.tireGateway.getById(data.tireId());
        if(tire == null){
            throw new Exception("Tire not found");
        }
        if(!tire.isActive()){
            throw new Exception("Tire not in use");
        }

        Truck truck = this.truckGateway.getTruckById(tire.getBelongsTo());

        if(truck.getCompany().getId().equals(truckCompany.getId())){
            tire.setActive(false);
            this.tireGateway.updateTire(tire);

            Tire newTire = Tire.builder()
                    .km(0)
                    .position(tire.getPosition())
                    .belongsTo(tire.getBelongsTo())
                    .description(data.description())
                    .isActive(true)
                    .build();
            Tire savedTire = this.tireGateway.saveTire(newTire);

            return savedTire;
        }else{
            throw new Exception("User not allowed to modify this truck");
        }
    }
}
