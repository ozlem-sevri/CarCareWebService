package com.example.carsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class Product {
    @NotEmpty(message = "Product name cannot be empty")
    private String name;
    @Min(value = 100, message = "Price should be at least 100.0")
    private double price;
}
