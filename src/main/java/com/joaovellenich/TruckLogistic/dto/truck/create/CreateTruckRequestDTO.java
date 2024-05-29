package com.joaovellenich.TruckLogistic.dto.truck.create;

import com.joaovellenich.TruckLogistic.model.Tire;
import lombok.Builder;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Builder
public record CreateTruckRequestDTO (
        String plate,
        String description,
        Double km,
        boolean hasNewTires,
        int numberOfAxle,
        List<Tire> tires
) {
}
