package com.example.carsystem.model;

import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder(toBuilder = true)
@Document(collection = "CarService")
public class CarCare {
    @Id
    @Generated
    private String id;
    @Valid
    private Customer customer;
    @Indexed(unique = true)
    @Valid
    private Car car;
    private List<Product> products ;
}
