package com.example.carsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class Car {
    @Indexed(unique = true)
    @NotEmpty(message = "Licence plate cannot be empty")
    private String licencePlate;
    @NotEmpty(message = "Brand cannot be empty")
    private String brand;
    @NotEmpty(message = "Model cannot be empty")
    private String model;
    private String color;
}
