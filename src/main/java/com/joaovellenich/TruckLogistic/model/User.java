package com.joaovellenich.TruckLogistic.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Builder
@Getter
@Setter
public class User {

    private UUID id;
    private String name;
    private String email;
    private String password;

    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
}
